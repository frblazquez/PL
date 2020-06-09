package ast.expressions.access;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.ArrayType;
import ast.types.IntType;
import ast.types.RegisterType;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class VariableAccess extends Expression {

    protected Identifier identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	super(id);
	identifier = new Identifier(id);
	accesses = a;
	children.addAll(accesses);
    }

    public Identifier getIdentifier() {
	return identifier;
    }
    
    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	Type t = st.get(identifier).getType();

	for(Access ac : accesses) {
	    if (t instanceof ArrayType && ac instanceof ArrayAccess) {
		ArrayType taux = ((ArrayType) t);
		ArrayAccess acaux = ((ArrayAccess) ac);
		acaux.getIndex().checkSemantics(st);

		if (!acaux.getIndex().getType().equals(IntType.INT_TYPE))
		    throw new SemanticErrorException("Array index must be an arithmetic expression", this.line);

		t = taux.getBaseType();
	    } else if (t instanceof RegisterType && ac instanceof RegisterAccess) {
		RegisterType taux = ((RegisterType) t);
		RegisterAccess acaux = ((RegisterAccess) ac);

		if (acaux.getIndex() >= taux.getRegisterSize())
		    throw new SemanticErrorException("Register index out of bound", this.line);

		t = taux.getEntryType(acaux.getIndex());
	    } else
		throw new SemanticErrorException("Illegal variable access to \"" + identifier + "\": " + ac, this.line);
	}

	expression_type = t;
	this.st = st;
    }
    
 // Produce the code necessary to place the exact address on top of stack
    public CodeLines produceStoreCode() {
    	CodeLines cls = new CodeLines();
    	SymbolTableEntry ste = st.getCertain(identifier);
    	// Set start of memory position at identifier's base address
    	cls.add(new CodeLine(PMachineInstructions.LDC, Integer.toString(ste.getAddr())));
    	Type t = st.getCertain(identifier).getType();
    	for (Access ac : accesses) {
    		if (ac instanceof ArrayAccess) {
    			ArrayType taux = ((ArrayType) t);
    			ArrayAccess acaux = (ArrayAccess) ac;
    			acaux.getIndex().produceCode(); // Produce code of index expression
    			int size_per_element = taux.getBaseType().getSize();
    			// Multiply index by base type size
    			cls.add(new CodeLine(PMachineInstructions.LDC,Integer.toString(size_per_element)));
    			cls.add(new CodeLine(PMachineInstructions.MUL));
    			// Now add current shift with new shift
    			cls.add(new CodeLine(PMachineInstructions.ADD));
    			t = taux.getBaseType();
    		} else if (ac instanceof RegisterAccess) {
    			RegisterType taux = ((RegisterType) t);
    			RegisterAccess acaux = ((RegisterAccess) ac);
    			// Index can be statically determined
    			int index = acaux.getIndex();
    			int shift = 0;
    			for (int i = 0; i < index; ++i) { // Add shift for each entry before index
    				shift += taux.getEntryType(i).getSize();
    			}
    			cls.add(new CodeLine(PMachineInstructions.LDC,Integer.toString(shift)));
    			cls.add(new CodeLine(PMachineInstructions.ADD));
    			t = taux.getEntryType(index);
    		}
    	}
    	return cls;
    }
    
    // Produce the code necessary to evaluate as expression
    @Override
    public CodeLines produceCode() {
    	CodeLines cls = new CodeLines();
    	cls.addAll(this.produceStoreCode());
    	cls.add(new CodeLine(PMachineInstructions.IND));
    	return cls;
    }
}

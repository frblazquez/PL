package ast.expressions.access;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.ArrayType;
import ast.types.IntType;
import ast.types.RegisterType;
import ast.types.Type;

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
    }
}

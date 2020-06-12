package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.AstUtils;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Definition extends Instruction {

    private Type type;
    private Identifier identifier;
    private Expression initialization;

    public Definition(Type t, String id) {
	this(t, id, null);
    }

    public Definition(Type t, String id, Expression e) {
	super(AstUtils.DEFINITION_HEADER);
	type = t;
	identifier = new Identifier(id);
	initialization = e;

	children.add(t);
	children.add(identifier);
	if (e != null)
	    children.add(e);
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	if (initialization != null) {
	    initialization.checkSemantics(st);

	    if (!type.equals(initialization.getType()))
		throw new SemanticErrorException("Definition type and initialization expression type do not match", this.line);
	}

	st.makeBinding(identifier, new SymbolTableEntry(type));
	this.st = st;
    }
    
    @Override
    public void produceCode(CodeLines cls) {
	// The only code a definition produces is (potentially) intialization
	if (initialization != null) {
	    // First get the initialization expression value on top of stack
	    initialization.produceCode(cls);
	    SymbolTableEntry ste = st.getCertain(identifier);
	    cls.add(new CodeLine(PMachineInstructions.STR, "0", Integer.toString(ste.getAddr())));
	}
    }
    
    @Override
    public int stackEvaluationSize() {
	if (initialization != null) return initialization.stackEvaluationSize();
	else return 0;
    }
    
    @Override
    public int staticDataSize() {
	return this.st.getNextFreeAddress();
    }
}

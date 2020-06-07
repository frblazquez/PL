package ast.instructions;

import asem.MemoryAddress;
import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.AstUtils;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.Type;

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
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {

	if (initialization != null) {
	    initialization.checkSemantics(st);

	    if (!type.equals(initialization.getType()))
		throw new SemanticErrorException("Definition type and initialization expression type do not match", this.line);
	}

	SymbolTable newSt = new SymbolTable(st);
	newSt.makeBinding(identifier, new SymbolTableEntry(new MemoryAddress(), type));
	return newSt;
    }
}

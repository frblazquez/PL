package ast.instructions;

import asem.MemoryAddress;
import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.AstUtils;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.IntType;
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
    
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	try
    	{
    		// Add binding of identifier
    		st.makeBinding(identifier, new SymbolTableEntry(new MemoryAddress(), type));
    	}
    	catch (SemanticErrorException se)
    	{
    		se.printSemanticError();
    	}
    	
    	if (initialization != null) 
    	{
    		try
    		{
    			initialization.checkSemantics(st);
    		}
    		catch (SemanticErrorException se)
    		{
    			se.printSemanticError();
    		}
    	}
    	return st;
    }
}

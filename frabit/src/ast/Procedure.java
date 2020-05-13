package ast;

import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.arguments.ArgumentsDefinition;
import ast.instructions.Instructions;

public class Procedure extends AstNode {

    protected Identifier identifier;
    protected Instructions instructions;
    protected ArgumentsDefinition arguments;

    public Procedure(String id, ArgumentsDefinition args, Instructions insts) {
	this(AstUtils.PROCEDURE_HEADER, id, args, insts);
    }

    /**
     * This constructor allows us to give an own header to function instances
     * (Function extends Procedure).
     */
    public Procedure(String header, String id, ArgumentsDefinition args, Instructions insts) {
	super(header);
	identifier = new Identifier(id);
	instructions = insts;
	arguments = args;

	children.add(identifier);
	children.add(arguments);
	children.add(instructions);
    }
    
    public Identifier getIdentifier()
    {
    	return identifier;
    }

    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	st = arguments.checkSemantics(st); // Symbol table is updated by arguments
    	instructions.checkSemantics(st);
    	return st;
    }
}

package ast;

import ast.arguments.ArgumentsDefinition;
import ast.instructions.Instructions;

public class Procedure extends AstNode {

    protected String identifier;
    protected Instructions instructions;
    protected ArgumentsDefinition arguments;

    public Procedure(String id, ArgumentsDefinition args, Instructions insts) {
	this(AstUtils.PROCEDURE_HEADER, id, args, insts);
    }

    public Procedure(String header, String id, ArgumentsDefinition args, Instructions insts) {
	super(header + "\"" + id + "\"");
	identifier = id;
	instructions = insts;
	arguments = args;

	// TODO: Should the identifier be printed in the header? If not add it here.
	// children.add(identifier);

	// TODO: Should parameters section appear in the tree representation if the
	// function has no parameters? If not add "arguments" under that condition.
	children.add(arguments);
	children.add(instructions);
    }

}

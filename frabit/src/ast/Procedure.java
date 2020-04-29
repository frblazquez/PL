package ast;

import ast.arguments.ArgumentsDefinition;
import ast.instructions.Instructions;
import ast.types.Type;

public class Procedure extends AstNode {

    protected String identifier;
    protected Instructions instructions;
    protected ArgumentsDefinition arguments;

    public Procedure(String id, ArgumentsDefinition args, Instructions insts) {
	this(AstUtils.PROCEDURE_HEADER, null, id, args, insts);
    }

    public Procedure(String header, Type tp, String id, ArgumentsDefinition args, Instructions insts) {
	super(header);
	if (tp != null)
	{
		children.add(tp);
	}
	children.add(new AstNode(AstUtils.ID_HEADER + id));
	identifier = id;
	instructions = insts;
	arguments = args;

	children.add(arguments);
	children.add(instructions);
    }

}

package ast.instructions;

import ast.AstUtils;
import ast.arguments.Arguments;

public class Call extends Instruction {

    private String identifier;
    private Arguments arguments;

    public Call(String id, Arguments args) {
	super(AstUtils.INVOKE_HEADER + "\"" + id + "\"");
	identifier = id;
	arguments = args;

	// TODO: Again is the header the best place for the idientifier?
	// children.add(id);

	// TODO: Should we add arguments section to the tree if there are no parameters?
	// TODO: Furthermore, even if we don't want to print this section when there are
	// no parameters, is the best way of doing this not adding it to the tree?
	children.add(args);
    }
}

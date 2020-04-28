package ast.arguments;

import java.util.ArrayList;
import java.util.List;

import ast.AstNode;
import ast.AstUtils;


public class ArgumentsDefinition extends AstNode {

    private List<PairArgumentType> arguments;

    public ArgumentsDefinition() {
	super(AstUtils.PARAMS_DEF_HEADER);
	arguments = new ArrayList<PairArgumentType>();
    }

    public ArgumentsDefinition(List<PairArgumentType> args) {
	super(AstUtils.PARAMS_DEF_HEADER);
	arguments = args;

	children.addAll(args);
    }
}

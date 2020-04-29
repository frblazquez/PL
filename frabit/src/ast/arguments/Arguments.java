package ast.arguments;

import java.util.ArrayList;
import java.util.List;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;

public class Arguments extends AstNode {

    private List<Expression> arguments;

    public Arguments() {
	super(AstUtils.PARAMS_HEADER);
	arguments = new ArrayList<Expression>();
    }

    public Arguments(List<Expression> args) {
	super(AstUtils.PARAMS_HEADER);
	arguments = args;
	children.addAll(arguments);
    }
}

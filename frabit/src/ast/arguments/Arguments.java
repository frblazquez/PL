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

    public int getNumOfArguments() {
	return arguments.size();
    }

    public Expression getArgument(int pos) {
	return arguments.get(pos);
    }

    public List<Expression> getArguments() {
	return arguments;
    }
    
    @Override
    public int stackEvaluationSize() {
	int max = 0;
	int i = 0;
	for (Expression ex : arguments) {
	    max = Math.max(Math.max(max, i + ex.stackEvaluationSize()), i + ex.getType().getSize());
	    i += ex.getType().getSize();
	}
	return max;
    }
}

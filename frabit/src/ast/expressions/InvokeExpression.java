package ast.expressions;

import ast.arguments.Arguments;

/**
 * This class has almost the same schema than Call class, however, this is not
 * an instruction. Only difference is the Type attribute inherited from
 * Expression.
 * 
 */
public class InvokeExpression extends Expression {

    private String identifier;
    private Arguments arguments;

    public InvokeExpression(String id, Arguments args) {
	identifier = id;
	arguments = args;
    }

    @Override
    public String toString() {
	return identifier + "(" + arguments + ")";
    }
}

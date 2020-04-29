package ast.expressions;

import ast.AstUtils;
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
	super(AstUtils.INVOKE_HEADER + id);
    
	identifier = id;
	arguments = args;
	children.add(args);
    }

    @Override
    public String toString() {
	return identifier + "(" + arguments + ")";
    }
}

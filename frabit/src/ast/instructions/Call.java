package ast.instructions;

import ast.AstUtils;
import ast.arguments.Arguments;
import ast.expressions.InvokeExpression;

public class Call extends Instruction {

	private InvokeExpression expr;
	
    public Call(InvokeExpression expr) {
	super(AstUtils.CALL_HEADER);
	this.expr = expr;
	children.add(expr);
    }
}

package ast.instructions;

import ast.AstUtils;
import ast.expressions.InvokeExpression;

public class Call extends Instruction {

    private InvokeExpression expr;

    public Call(InvokeExpression expr) {
	super(AstUtils.CALL_HEADER);
	this.expr = expr;
	children.add(expr);
    }

    @Override
    public void astToString(StringBuilder sb, String prefix, String children_prefix) {
	expr.astToString(sb, prefix, children_prefix);
    }
    
    @Override
    public int stackEvaluationSize() {
    	return expr.stackEvaluationSize();
    }
}

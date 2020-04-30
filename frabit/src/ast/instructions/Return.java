package ast.instructions;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;

public class Return extends AstNode {

    private Expression expression;

    public Return(Expression ret_expr) {
	super(AstUtils.RETURN_HEADER);
	expression = ret_expr;

	children.add(ret_expr);
    }
}

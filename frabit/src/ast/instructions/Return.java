package ast.instructions;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;

public class Return extends AstNode{
	public Return(Expression ret_expr)
	{
		super(AstUtils.RETURN_HEADER);
		children.add(ret_expr);
	}
}

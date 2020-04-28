package ast.expressions.access;

import ast.AstNode;
import ast.expressions.Expression;

public abstract class Access extends AstNode
{
	public abstract Expression getExpression();
}

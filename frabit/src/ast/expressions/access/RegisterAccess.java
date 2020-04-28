package ast.expressions.access;

import ast.expressions.Expression;

public class RegisterAccess extends Access {

    private int index;

    public RegisterAccess(int idx) {
	index = idx;
    }

    @Override
    public Expression getExpression() {
	return new Expression(String.valueOf(index));
    }
    
}

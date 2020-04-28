package ast.expressions.access;

import ast.expressions.Expression;

public class ArrayAccess extends Access {

    private Expression index;

    public ArrayAccess(Expression e) {
	index = e;
    }

    public Expression getIndex() {
	return index;
    }

    @Override
    public String toString() {
	return "[" + index + "]";
    }

}

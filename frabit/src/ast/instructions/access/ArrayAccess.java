package ast.instructions.access;

import ast.expressions.Expression;

public class ArrayAccess extends Access {

    private Expression index;

    public ArrayAccess(Expression e) {
	index = e;
    }
    
    public Expression getIndex() { return index; }

}

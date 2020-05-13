package ast.expressions.access;

import asem.SymbolTable;
import ast.expressions.Expression;

public class ArrayAccess extends Access {

    private Expression index;

    public ArrayAccess(Expression e) {
    	super("[]");
    	index = e;
    	children.add(e);
    }

    public Expression getIndex() {
	return index;
    }

    @Override
    public String toString() {
	return "[" + index + "]";
    }
}

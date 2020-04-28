package ast.expressions;

import ast.types.Type;

public class Constant extends Expression {

    private String constant;

    public Constant(String ct) {
	constant = ct;
    }

    public Constant(String ct, Type type) {
	super(type);
	constant = ct;
    }

    @Override
    public String toString() {
	return constant;
    }

}

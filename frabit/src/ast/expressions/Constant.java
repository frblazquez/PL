package ast.expressions;

import ast.types.Type;

public class Constant extends Expression {

    private String constant;

    public Constant(String ct) {
    	super(ct);
    	constant = ct;
    }

    public Constant(String ct, Type type) {
	super(ct);
	constant = ct;
	expression_type = type;
    }

    @Override
    public String toString() {
	return constant;
    }

}

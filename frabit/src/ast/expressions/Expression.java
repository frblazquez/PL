package ast.expressions;

import ast.AstNode;

public class Expression extends AstNode {

    private String operator;
    private int noperands;
    private Expression[] operands;

    public Expression() {
    }

    // Note that a constant is the same as a 0-ary operation
    public Expression(String constant) {
	operator = constant;
	noperands = 0;
	operands = null;
    }

    public Expression(String op, int nop, Expression[] opers) {
	operator = op;
	noperands = nop;
	operands = opers;
    }
}
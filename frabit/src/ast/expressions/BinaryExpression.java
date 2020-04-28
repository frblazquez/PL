package ast.expressions;

public class BinaryExpression extends Expression {

    private Operators op;
    private Expression left_e;
    private Expression right_e;

    public BinaryExpression(Operators op, Expression left_e, Expression right_e) {
	this.op = op;
	this.left_e = left_e;
	this.right_e = right_e;
    }

    @Override
    public String toString() {
	return left_e + " " + op + " " + right_e;
    }

}

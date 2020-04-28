package ast.expressions;

public class UnaryExpression extends Expression {

    private Operators op;
    private Expression exp;

    public UnaryExpression(Operators op, Expression exp) {
	this.op = op;
	this.exp = exp;
    }

    @Override
    public String toString() {
	return op + " " + exp;
    }
}

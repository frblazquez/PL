package ast.expressions;

import asem.SemanticErrorException;
import asem.SymbolTable;

public class UnaryExpression extends Expression {

    private Operators op;
    private Expression exp;

    public UnaryExpression(Operators op, Expression exp) {
	super(op.toString());
	children.add(exp);
	this.op = op;
	this.exp = exp;
    }

    @Override
    public String toString() {
	return op + " " + exp;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	if (op.getArity() != 1)
	    throw new SemanticErrorException("Operator \"" + op + "\" is not an unary operator", this.line);

	exp.checkSemantics(st);

	if (!op.operandType().equals(exp.getType()))
	    throw new SemanticErrorException("Operand types do not match in expression", this.line);

	expression_type = op.resultType();
    }
}

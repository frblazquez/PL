package ast.expressions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import code.CodeLine;
import code.CodeLines;

public class BinaryExpression extends Expression {

    private Operators op;
    private Expression left_e;
    private Expression right_e;

    public BinaryExpression(Operators op, Expression left_e, Expression right_e) {
	super(op.toString());
	this.op = op;
	this.left_e = left_e;
	this.right_e = right_e;
	this.children.add(left_e);
	this.children.add(right_e);
    }

    @Override
    public String toString() {
	return left_e + " " + op + " " + right_e;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	if (op.getArity() != 2)
	    throw new SemanticErrorException("Operator \"" + op + "\" is not a binary operator", this.line);

	left_e.checkSemantics(st);
	right_e.checkSemantics(st);

	if (!op.operandType().equals(left_e.getType()) || !op.operandType().equals(right_e.getType()))
	    throw new SemanticErrorException("Operand types do not match in expression", this.line);

	expression_type = op.resultType();
	this.st = st;
    }
    
    @Override
    public void produceCode(CodeLines cls) {
	left_e.produceCode(cls);
	right_e.produceCode(cls);
    	cls.add(new CodeLine(op.opInstruction()));
    }

    @Override
    public int stackEvaluationSize() {
	return Math.max(left_e.stackEvaluationSize(),1 + right_e.stackEvaluationSize());
    }

}

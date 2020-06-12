package ast.expressions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstNode;
import ast.expressions.access.VariableAccess;
import ast.types.PointerType;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;

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
	
	if (op == Operators.AMPERSAND) {
		if (!(exp instanceof VariableAccess))
			throw new SemanticErrorException("Pointer operators demand a variable's name");
		VariableAccess va = (VariableAccess) exp;
		this.expression_type = new PointerType(va.getType());
	}
	else if (!op.operandType().equals(exp.getType()))
	    throw new SemanticErrorException("Operand types do not match in expression", this.line);

	expression_type = op.resultType();
	this.st = st;
    }

    @Override
    public void produceCode(CodeLines cls) {
    if (op == Operators.AMPERSAND || op == Operators.DEREF) {
    	this.producePtrCode(cls);
    	return;
    }
	exp.produceCode(cls);
	cls.add(new CodeLine(op.opInstruction()));
    }
    
    private void producePtrCode(CodeLines cls) {
	VariableAccess va = (VariableAccess) exp; // Semantics check requires that this is doable
	if (op == Operators.AMPERSAND) {
		va.produceStoreCode(cls); // Puts address of variable access on stack
	}
	else {
		va.produceCode(cls); // 
	}
    }
    
    @Override
    public int stackEvaluationSize() {
	return 1 + exp.stackEvaluationSize();
    }
}

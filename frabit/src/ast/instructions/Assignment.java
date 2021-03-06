package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.access.VariableAccess;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Assignment extends Instruction {

    private VariableAccess variable;
    private Expression expression;

    public Assignment(VariableAccess va, Expression e) {
	super(AstUtils.ASSIGNMENT_HEADER);
	variable = va;
	expression = e;

	children.add(variable);
	children.add(expression);
    }
    
    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	variable.checkSemantics(st);
	expression.checkSemantics(st);
	
	if (!variable.getType().equals(expression.getType()))
	    throw new SemanticErrorException("Assignment types do not match", this.line);
	if (variable.getType().getSize() != 1)
		throw new SemanticErrorException("Only one word elements can be assigned at a time", this.line);
	this.st = st;
    }

    @Override
    public void produceCode(CodeLines cls) {
	variable.produceStoreCode(cls);
	expression.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.STO));
    }
    
    @Override
    public int stackEvaluationSize() {
	int size0 = variable.stackEvaluationSize();
	int size1 = 1 + expression.stackEvaluationSize();
	return Math.max(size0, size1);
    }
    
}

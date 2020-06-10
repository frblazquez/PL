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
	this.st = st;
    }

    @Override
    public void produceCode(CodeLines cls) {
	variable.produceStoreCode(cls);
	expression.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.STO));
    }
}

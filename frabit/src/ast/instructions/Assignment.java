package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
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
    public CodeLines produceCode()
    {
	CodeLines cls = new CodeLines();
	// The only code a definition produces is (potentially) intialization
	// First do whatever it takes to get value of expression on top of stack
	cls.addAll(variable.produceStoreCode());
	cls.addAll(expression.produceCode());
	cls.add(new CodeLine(PMachineInstructions.STO));
	return cls;
    }
}

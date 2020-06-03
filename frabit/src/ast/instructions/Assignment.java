package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.access.VariableAccess;

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
    
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
	// TODO: This is for checking the semantics of the variable access and the expression, right?
    	super.checkSemantics(st);
    	
	// TODO: IMPORTANT
	// Different register instances are different types (for example). Our
	// expression can be an invoke so checking only the class is not enough. We
	// should define properly equals method in Type..
    	if (variable.getType(st).getClass() 
    		!= 
    	    expression.getType(st).getClass())
    		throw new SemanticErrorException("Assignment types do not match",this.line);
    	return st;
    }

}

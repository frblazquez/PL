package ast.instructions;

import ast.AstAux;
import ast.expressions.Expression;
import ast.instructions.access.VariableAccess;

public class Assignment extends Instruction {

    private VariableAccess variable;
    private Expression expression;

    public Assignment(VariableAccess va, Expression e) {
	variable = va;
	expression = e;
    }

    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\__Assignment\n";
    	String blanks = AstAux.blanks("Assignment".length());
    	ret += variable.astString(prefix + blanks + "|");
    	ret += expression.astString(prefix + blanks  + " ");
    	return ret; 
    }
}

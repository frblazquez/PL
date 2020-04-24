package ast.instructions;

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
    	String ret, nprefix;
    	nprefix = prefix + "    ";
    	ret = prefix.substring(0,prefix.length()-1) + "\\__=\n"; 
	ret += nprefix + "\\__" + variable.getIdentifier() + "\n";
    	ret += expression.astString(nprefix + " ");
    	return ret; 
    }
}

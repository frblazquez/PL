package ast;

import java.util.HashMap;

import ast.expressions.Expression;
import ast.instructions.Instructions;
import ast.types.Type;

public class Function extends Procedure {

    private Expression return_expression;
    private Type return_type;

    public Function(String id, HashMap<String, Type> args, Instructions insts, Type t, Expression e) {
	super(id, args, insts);
	return_type = t;
	return_expression = e;
    }
    
    String astString(String prefix)
    {
    	String ret;
    	ret = AstAux.popLast(prefix) + "\\__Function\n";
    	String blanks = AstAux.blanks("Function".length());
    	ret += prefix + blanks + "\\" + return_type.toString() + "\n";
    	ret +=  prefix + blanks + "\\" + identifier + "\n";
    	ret += instructions.astString(prefix + blanks + "|");
    	ret += prefix + blanks + "\\return\n";
    	ret += return_expression.astString(prefix + blanks + " ");
    	return ret;
    }
}

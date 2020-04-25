package ast.instructions;

import ast.AstAux;
import ast.expressions.Expression;
import ast.types.Type;

public class Definition extends Instruction {

    private Type type;
    private String identifier;
    private Expression initialization;

    public Definition(Type t, String id) {
	type = t;
	identifier = id;
	initialization = null;
    }

    public Definition(Type t, String id, Expression e) {
	type = t;
	identifier = id;
	initialization = e;
    }
    
    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\__Definition\n";
    	String blanks = AstAux.blanks("Definition".length());
    	ret += prefix + blanks + "\\" + type.toString() + "\n";
    	ret += prefix + blanks + "\\" + identifier + "\n";
    	if (initialization != null)
    		ret += initialization.astString(prefix + blanks + " ");
    	return ret;
    }
}

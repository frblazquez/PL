package ast.instructions;

import ast.Expression;
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
    	String ret = prefix.substring(0,prefix.length()-1) + "\\__" + type.toString() + " " + identifier;
    	if (initialization != null)
    		ret += "=\n" + initialization.astString(prefix + "     ");
    	else ret += "\n";
    	return ret;
    }
}

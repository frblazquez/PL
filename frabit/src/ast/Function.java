package ast;

import java.util.List;
import java.util.HashMap;

import ast.instructions.Instruction;
import ast.instructions.Instructions;
import ast.types.Type;

public class Function extends Procedure {

    private Expression return_expression;
    private Type return_type;

    // TODO: Remove constructor when possible
    public Function(String id, Instructions insts) {
	super(id, insts);
    }

    // TODO: Remove constructor when possible
    public Function(String id, Instructions insts, Type t, Expression e) {
	super(id, insts);
	return_type = t;
	return_expression = e;
    }

    public Function(String id, HashMap<String, Type> args, Instructions insts, Type t, Expression e) {
	super(id, args, insts);
	return_type = t;
	return_expression = e;
    }
    
    String astString(String prefix)
    {
    	String ret;
    	ret = prefix.substring(0,prefix.length()-1).concat("\\__" + return_type.toString() + " " + identifier + "\n");
    	ret += instructions.astString(prefix);
    	return ret;
    }
}

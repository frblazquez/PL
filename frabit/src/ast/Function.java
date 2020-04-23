package ast;

import java.util.List;
import java.util.HashMap;

import ast.instructions.Instruction;
import ast.types.Type;

public class Function extends Procedure {

    private Expression return_expression;
    private Type return_type;

    // TODO: Remove constructor when possible
    public Function(String id, List<Instruction> insts) {
	super(id, insts);
    }

    // TODO: Remove constructor when possible
    public Function(String id, List<Instruction> insts, Type t, Expression e) {
	super(id, insts);
	return_type = t;
	return_expression = e;
    }

    public Function(String id, HashMap<String, Type> args, List<Instruction> insts, Type t, Expression e) {
	super(id, args, insts);
	return_type = t;
	return_expression = e;
    }
    
    String astString(String prefix)
    {
    	String ret; String tab = "    ";
    	String nprefix = prefix +"|"+ tab;
    	ret = prefix.concat(return_type.toString() + " " + identifier + "\n");
    	for (Instruction ins : instructions)
    	{
    		ret += ins.astString(nprefix);
    	}
    	return ret;
    }
}

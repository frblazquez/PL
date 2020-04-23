package ast;

import java.util.List;
import java.util.HashMap;

import ast.instructions.Instruction;
import ast.types.Type;

public class Procedure {

    protected String identifier;
    protected List<Instruction> instructions;
    protected HashMap<String, Type> arguments;

    // TODO: Remove constructor when possible
    public Procedure(String id, List<Instruction> insts) {
	identifier = id;
	instructions = insts;
    }

    public Procedure(String id, HashMap<String, Type> args, List<Instruction> insts) {
	identifier = id;
	instructions = insts;
	arguments = args;
    }

    String astString(String prefix)
    {
    	String ret; String tab = "    ";
    	String nprefix = prefix +"|"+ tab;
    	ret = prefix.concat("\\void " + identifier + "\n");
    	for (Instruction ins : instructions)
    	{
    		ret += ins.astString(nprefix);
    	}
    	return ret;
    }
}

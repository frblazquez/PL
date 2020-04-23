package ast;

import java.util.HashMap;

import ast.instructions.Instructions;
import ast.types.Type;

public class Procedure {

    protected String identifier;
    protected Instructions instructions;
    protected HashMap<String, Type> arguments;

    // TODO: Remove constructor when possible
    public Procedure(String id, Instructions insts) {
	identifier = id;
	instructions = insts;
    }

    public Procedure(String id, HashMap<String, Type> args, Instructions insts) {
	identifier = id;
	instructions = insts;
	arguments = args;
    }

    String astString(String prefix)
    {
    	String ret;
    	ret = prefix.substring(0,prefix.length()-1).concat("\\__void " + identifier + "\n");
    	ret += instructions.astString(prefix);
    	return ret;
    }
}

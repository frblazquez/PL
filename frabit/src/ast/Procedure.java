package ast;

import java.util.HashMap;

import ast.instructions.Instructions;
import ast.types.Type;

public class Procedure {

    protected String identifier;
    protected Instructions instructions;
    protected HashMap<String, Type> arguments;

    public Procedure(String id, HashMap<String, Type> args, Instructions insts) {
	identifier = id;
	instructions = insts;
	arguments = args;
    }

    String astString(String prefix)
    {
    	String ret;
    	ret = prefix.substring(0,prefix.length()-1) + "\\__Procedure\n";
    	ret += prefix + "    \\void\n";
    	ret +=  prefix + "    \\" + identifier + "\n";
    	ret += instructions.astString(prefix + "     ");
    	return ret;
    }
   }

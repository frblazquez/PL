package ast.instructions;

import java.util.List;

import ast.Expression;

public class While extends Instruction {

    private Expression condition;
    private Instructions instructions;

    public While(Expression e, Instructions ins) {
	condition = e;
	instructions = ins;
    }

    public String astString(String prefix)
    {
    	String ret = "", tab = "    ", nprefix = prefix + tab;
    	ret = prefix.substring(0,prefix.length() - 1) + "\\__while\n";
    	ret += condition.astString(nprefix + "|");
    	ret += instructions.astString(prefix);
    	return ret;
    }
}

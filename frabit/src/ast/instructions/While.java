package ast.instructions;

import java.util.List;

import ast.Expression;

public class While extends Instruction {

    private Expression condition;
    private List<Instruction> instructions;

    public While(Expression e, List<Instruction> ins) {
	condition = e;
	instructions = ins;
    }

    public String astString(String prefix)
    {
    	String ret = "", tab = "    ", nprefix = prefix + tab;
    	ret = prefix.substring(0,prefix.length() - 1) + "\\__while\n";
    	ret += condition.astString(nprefix);
    	for (int i = 0; i < instructions.size(); ++i)
    	{
    		if (i < instructions.size() - 1)
    			ret += instructions.get(i).astString(nprefix.substring(0, nprefix.length()-1) + "|");
    		else
    			ret += instructions.get(i).astString(nprefix.substring(0, nprefix.length()-1) + " ");
    	}
    	return ret;
    }
}

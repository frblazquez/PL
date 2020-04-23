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
    	String ret = "", tab = "    ", nprefix = prefix + "|" + tab;
    	ret = prefix + "\\__while\n";
    	ret += condition.astString(nprefix);
    	for (Instruction inst : instructions)
    	{
    		ret += inst.astString(nprefix);
    	}
    	return ret;
    }
}

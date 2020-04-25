package ast.instructions;

import java.util.ArrayList;
import java.util.List;

import ast.AstAux;

public class Instructions {
	protected List<Instruction> instructions;
	
	public Instructions()
	{
		instructions = new ArrayList<Instruction>();
	}
	
	public void add(Instruction instr)
	{
		instructions.add(instr);
	}
	
	public String astString(String prefix)
	{
    	String ret = "";
    	String blanks;
    	ret += prefix.substring(0,prefix.length()-1) + "\\InstrBlock\n";
    	blanks = AstAux.blanks("InstrBlock".length());
		for (int i = 0; i < instructions.size(); ++i)
    	{
    		if (i < instructions.size() - 1)
    			ret += instructions.get(i).astString(prefix + blanks + "|");
    		else
    			ret += instructions.get(i).astString(prefix + blanks + " ");
    	}
		return ret;
	}
	
}

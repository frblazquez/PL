package ast.instructions;

import java.util.ArrayList;
import java.util.List;

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
    	String nprefix = prefix + "    ";
		for (int i = 0; i < instructions.size(); ++i)
    	{
    		if (i < instructions.size() - 1)
    			ret += instructions.get(i).astString(nprefix + "|");
    		else
    			ret += instructions.get(i).astString(nprefix + " ");
    	}
		return ret;
	}
	
}

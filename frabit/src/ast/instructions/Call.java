package ast.instructions;

import java.util.List;

import ast.AstAux;
import ast.expressions.Expression;

public class Call extends Instruction{

    private String identifier;
    private List<Expression> arguments;

    public Call(String id, List<Expression> args) {
	identifier = id;
	arguments = args;
    }
    
    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\Call\n";
    	String blanks = AstAux.blanks("Call".length());
    	ret += prefix + blanks + "\\" + identifier + "\n";
    	if (arguments.size() > 0)
    	{
    		ret += prefix + blanks + "\\__Arguments\n";
    		for (int i = 0; i < arguments.size(); ++i)
    		{
    			if (i < arguments.size() - 1)
    				ret += arguments.get(i).astString(prefix + blanks + "|" + blanks);
    			else
    				ret += arguments.get(i).astString(prefix + blanks + " " + blanks);
    		}
    	}
    	return ret;
    }
}

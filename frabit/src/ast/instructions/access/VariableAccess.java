package ast.instructions.access;

import java.util.List;
import ast.AstAux;
import ast.expressions.Expression;

public class VariableAccess extends Expression{

    protected String identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	identifier = id;
	accesses = a;
    }

    public String getIdentifier() {
	return identifier;
    }
    
    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\" + identifier + "\n";
    	String blanks = AstAux.blanks(identifier.length());
    	Access ac;
    	for (int i = 0; i < accesses.size(); ++i)
    	{
    		ac = accesses.get(i);
    		if (i < accesses.size() - 1)
    		{
    			if (ac instanceof ArrayAccess)
    			{
    				ret += prefix + blanks + "\\__[] \n";
    				ret += ac.getExpression().astString(prefix + blanks + "|" + AstAux.blanks(4)); 
    			}
    			else if (ac instanceof RegisterAccess)
    			{
    				ret += prefix + blanks + "\\__.\n";
    				ret += ac.getExpression().astString(prefix + blanks + "|" + AstAux.blanks(4));
    			}
    		}
    		else
    		{
    			if (ac instanceof ArrayAccess)
    			{
    				ret += prefix + blanks + "\\__[] \n";
    				ret += ac.getExpression().astString(prefix + blanks + " " + AstAux.blanks(4)); 
    			}
    			else if (ac instanceof RegisterAccess)
    			{
    				ret += prefix + blanks + "\\__.\n";
    				ret += ac.getExpression().astString(prefix + blanks + " " + AstAux.blanks(4));
    			}
    		}
    	}
    	return ret;
    }
}

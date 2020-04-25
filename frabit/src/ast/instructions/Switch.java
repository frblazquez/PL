package ast.instructions;

import java.util.List;

import ast.AstAux;
import ast.expressions.Expression;

public class Switch extends Instruction {

    private Expression base_expression;
    private List<Case> cases;
    private Case default_case;

    public Switch(Expression exp, List<Case> cases, Case default_case) {
	this.base_expression = exp;
	this.cases = cases;
	this.default_case = default_case;
    }

    public Switch(Expression exp, List<Case> cases) {
	this.base_expression = exp;
	this.cases = cases;
	this.default_case = null;
    }

//    public Switch(List<Case> cases) {
//	if (cases.get(cases.size() - 1).isDefault())
//	    default_case = cases.remove(cases.size() - 1);
//	else
//	    default_case = null;
//
//	this.cases = cases;
//    }
    
    public String astString(String prefix)
    {
    	String ret = prefix.substring(0,prefix.length()-1) + "\\__switch\n";
    	String blanks = AstAux.blanks("switch".length());
    	ret += base_expression.astString(prefix + blanks + "|");
    	for (int i = 0; i < cases.size(); ++i)
		{
    		if (i < cases.size() - 1 || default_case != null)
    			ret += cases.get(i).astString(prefix + blanks + "|");
    		else
        		ret += cases.get(i).astString(prefix + blanks + " ");
		}
    	if (default_case != null)
    		ret += default_case.astString(prefix + blanks + " ");
    	return ret;
    }
}

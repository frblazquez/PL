package ast.instructions;

import ast.AstAux;
import ast.expressions.Expression;

public class Case {

    private Expression exp;
    private Instructions ins;

    public Case(Expression e, Instructions is) {
	exp = e;
	ins = is;
    }

    public Case(Instructions is) {
	exp = null;
	ins = is;
    }

    public boolean isDefault() {
	return exp == null;
    }
    
    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\case\n";
    	ret += ins.astString(prefix + AstAux.blanks("case".length()));
    	return ret;
    }
}

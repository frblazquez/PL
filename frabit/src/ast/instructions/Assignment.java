package ast.instructions;

import ast.Expression;

public class Assignment extends Instruction {

    // TODO: Allow variable access (to initialize array positions, registers...)
    private String identifier;
    private Expression expression;

    public Assignment(String id, Expression e) {
	identifier = id;
	expression = e;
    }

    public String astString(String prefix)
    {
    	String ret, tab = "    ", nprefix;
    	nprefix = prefix + "|" + tab;
    	ret = prefix + "\\__=\n"; ret += nprefix + "\\__" + identifier + "\n";
    	ret += expression.astString(nprefix);
    	return ret; 
    }
}

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

//    public String astString(String prefix)
//    {
//    	String ret, tab = "    ", nprefix;
//    	nprefix = prefix + "|" + tab;
//    	return "\\=\n" + nprefix + "\\" + identifier + "\n" + expression.astString(nprefix); 
//    }
}

package ast.expressions;

import ast.AstAux;

public class Expression 
{
	private String operator;
	private int noperands;
	private Expression [] operands;
	
	public Expression() {}
	
	// Note that a constant is the same as a 0-ary operation
	public Expression(String constant)
	{
		operator = constant;
		noperands = 0;
		operands = null;
	}
	
	public Expression(String op, int nop, Expression [] opers)
	{
		operator = op;
		noperands = nop;
		operands = opers;
	}
	
	public String astString(String prefix)
	{
		String ret = AstAux.popLast(prefix) + "\\__" + operator + "\n";
		String blanks = AstAux.blanks(4);
		for (int i = 0; i < noperands - 1; ++i)
			ret += operands[i].astString(prefix + blanks + "|");
		if (noperands > 0)
			ret += operands[noperands - 1].astString(prefix + blanks + " ");
		
		return ret;
	}
}
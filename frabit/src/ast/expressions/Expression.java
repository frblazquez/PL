package ast.expressions;

public class Expression 
{
	private String operator;
	private int noperands;
	private Expression [] operands;
	
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
		String ret = prefix.substring(0,prefix.length()-1) + "\\__" + operator + "\n";
		String nprefix = prefix + "    ";
		for (int i = 0; i < noperands - 1; ++i)
			ret += operands[i].astString(nprefix + "|");
		if (noperands > 0)
			ret += operands[noperands - 1].astString(nprefix + " ");
		
		return ret;
	}
}

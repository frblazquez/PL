package ast.expressions;

public class Expression 
{
	protected Operation operation;
	protected int noperands;
	protected Expression [] operands;
	TypeOfExpression expr_type;
	
	public Expression() {}
	
	// Note that a constant is the same as a 0-ary operation
	public Expression(String constant)
	{
		operation = null;
		noperands = 0;
		operands = null;
		expr_type = null;
	}
	
	public Expression(String operstr, int noperands, Expression [] operands)
	{
		this.operation = Operation.strToOp(operstr);
		this.noperands = noperands;
		this.operands = operands;
	}
	
	public String astString(String prefix)
	{
		//String ret = prefix.substring(0,prefix.length()-1) + "\\__" + Operation.toString(operation) + "\n";
		
		String ret = "";
		if (operation == Operation.SUM) ret = prefix.substring(0,prefix.length()-1) + "\\__" + "+" + "\n";
		else ret= prefix.substring(0,prefix.length()-1) + "\\__" + operation + "\n";
		String nprefix = prefix + "    ";
		for (int i = 0; i < noperands - 1; ++i)
			ret += operands[i].astString(nprefix + "|");
		if (noperands > 0)
			ret += operands[noperands - 1].astString(nprefix + " ");
		
		return ret;
	}
}

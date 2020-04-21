package ast;

public abstract class FunProc {
	protected String identifier;
	private Instructions instructions;
	private Expression ret_expression;
	
	public FunProc()
	{
		identifier = new String();
	}
	public FunProc(String id)
	{
		identifier = id;
	}
	public void setIdentifier(String id)
	{
		identifier = id;
	}
	
	public String astString(String prefix)
	{
		return prefix.substring(0,prefix.length() - 1) + "\\__"+ this.toString() + "\n";
	}
	
	public String toString()
	{
		return "\"" + identifier + "\"";
	}
}

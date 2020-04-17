package ast_packages;

public abstract class FunProc {
	public String identifier;
	
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
	
	public String toString()
	{
		return identifier;
	}
}

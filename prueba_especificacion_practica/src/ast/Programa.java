package ast_packages;

public class Programa {
	public int x;
	private FunProcList functions;
	private MainFunction main_function;
	
	public Programa()
	{
		functions = new FunProcList();
		main_function = new MainFunction();
	}
	
	public void setFunProcList(FunProcList list)
	{
		functions = list;
	}
	
	public void setMain(MainFunction mf)
	{
		main_function = mf;
	}
	
	public MainFunction getMain()
	{
		return main_function;
	}
	
	public String toString()
	{
		return functions.toString();
	}
}

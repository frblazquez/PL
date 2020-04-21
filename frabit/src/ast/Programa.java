package ast;

public class Programa {
	public int x;
	private FunProcList functions;
	private MainFunction main_function;
	
	public Programa(FunProcList fplist, MainFunction mf)
	{
		functions = fplist;
		main_function = mf;
	}
	
	public MainFunction getMain()
	{
		return main_function;
	}
	
	public String toString()
	{
		return "Programa" + "\n" + functions.astString("  |") + main_function.astString("  |");
	}
}

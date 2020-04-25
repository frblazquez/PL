package ast;

public class AstAux {
	public static String blanks(int n)
	{
		String ret = "";
		for (int i = 0; i < n; ++i) ret += " ";
		return ret;
	}
	
	public static String popLast(String str)
	{
		return str.substring(0,str.length()-1);
	}
}

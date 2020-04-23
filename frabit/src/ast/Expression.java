package ast;

public class Expression {

	
	public String astString(String prefix)
	{
		return prefix.substring(0,prefix.length()-1) + "\\__expresion\n";
	}
}

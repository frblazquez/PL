package ast;
import java.util.Vector; 

public class FunProcList {
	private Vector<FunProc> functions;
	
	public FunProcList()
	{
		functions = new Vector<FunProc>();
	}
	
	public void add(FunProc fp)
	{
		functions.add(fp);
	}
	
	public String astString(String prefix)
	{
		String ret = "", blanks = "", title = "";
		title = "\\__FunProcList";
		ret = prefix.substring(0,prefix.length()-1) + title + "\n";
		for (int j = 0; j < title.length(); ++j) blanks += " ";
		for (int i = 0; i < functions.size(); ++i)
		{
			ret += functions.elementAt(i).astString(prefix + blanks + "|");
		}
		return ret;
	}
}

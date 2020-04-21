package ast_packages;
import java.util.LinkedList;
import java.util.ListIterator; 

public class FunProcList {
	private LinkedList<FunProc> functions;
	FunProc funs[];
	int nfuns = 0;
	public FunProcList()
	{
		functions = new LinkedList<FunProc>();
		funs = new FunProc[100];
	}
	
	public void add(FunProc fp)
	{
		functions.add(fp);
		funs[nfuns] = fp;
		nfuns += 1;
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < nfuns; ++i)
		{
			str += funs[i].toString() + '\n';
		}
		return str;
	}
}

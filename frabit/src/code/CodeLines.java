package code;

import java.util.LinkedList;
import java.util.List;

public class CodeLines {
	private int nlines;
	private List<CodeLine> codelines;
	
	public CodeLines()
	{
		nlines = 0;
		codelines = new LinkedList<CodeLine>();
	}
	
	public CodeLines(int nlines, LinkedList<CodeLine> cls)
	{
		this.nlines = nlines;
		codelines = cls;
	}
	
	public void add(CodeLine cl)
	{
		codelines.add(cl);
		++nlines;
	}
	
    public int getNLines() {
	return nlines;
    }

    public void modify(int codeLine, int parameter) {
	codelines.get(codeLine).setParameter("" + parameter);
    }
	public List<CodeLine> getCodeLines()
	{ return codelines; }
	
	public void addAll(CodeLines cls)
	{
		codelines.addAll(cls.codelines);
		nlines += cls.nlines;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (CodeLine cl : codelines) {
			sb.append(cl.toString());
			sb.append('\n');
		}
		return sb.toString();
	}
}

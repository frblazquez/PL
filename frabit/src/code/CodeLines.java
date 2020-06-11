package code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ast.Identifier;

public class CodeLines {
    private int nlines;
    private List<CodeLine> codelines;

    // TODO: Check this!
    // Methods can be here because their scope is the whole program!
    private HashMap<Identifier, Integer> method_firstInstruction;
    // And we have this because we allow mutual recursion, we might have an
    // invocation to a method even before this method is translated to pcode!
    private HashMap<Integer, Identifier> line_unsolvedJumpReference;

    public CodeLines() {
	nlines = 0;
	codelines = new LinkedList<CodeLine>();
	method_firstInstruction = new HashMap<>();
	line_unsolvedJumpReference = new HashMap<>();
    }

    public CodeLines(int nlines, LinkedList<CodeLine> cls) {
	this.nlines = nlines;
	codelines = cls;
	method_firstInstruction = new HashMap<>();
	line_unsolvedJumpReference = new HashMap<>();
    }

    public void add(CodeLine cl) {
	codelines.add(cl);
	++nlines;
    }

    public int getNLines() {
	return nlines;
    }

    public void modify(int codeLine, int parameter) {
	codelines.get(codeLine).setFirstParameter("" + parameter);
    }

    public List<CodeLine> getCodeLines() {
	return codelines;
    }

    public void addAll(CodeLines cls) {
	codelines.addAll(cls.codelines);
	nlines += cls.nlines;
    }

    public void addMethod(Identifier id, int startPC) {
	method_firstInstruction.put(id, startPC);
    }
    
    public void setUnsolvedReference(Integer line, Identifier identifier) {
    	line_unsolvedJumpReference.put(line,identifier);
    }

    public String toString() {
	StringBuilder sb = new StringBuilder("");
	int line = 0;
	for(CodeLine cl : codelines) {
	    sb.append('{'); sb.append(line); sb.append('}');
	    sb.append(' ');
	    cl.appendLine(sb);
	    sb.append('\n');
	    ++line;
	}
	return sb.toString();
    }

	public void setCallAddresses() {
	Integer i = 0;
	for (CodeLine cl : codelines) {
		if (cl.getInstruction() == PMachineInstructions.CUP) {
			Identifier identifier = line_unsolvedJumpReference.get(i);
			cl.setSecondParameter(Integer.toString(method_firstInstruction.get(identifier)));
		}
		i = i + 1;	
	}
	}
}

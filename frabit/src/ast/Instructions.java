package ast;
import java.util.Vector;

public class Instructions {
	private Vector<Instruction> instructions;
	
	public Instructions() {}
	public void add(Instruction inst) { instructions.add(inst); }
}

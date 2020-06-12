package ast.expressions.access;

import java.util.List;

import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Dereferencing extends VariableAccess {
	
	public Dereferencing(String id, List<Access> a) {
		super(id,a);
	}
	
	@Override
	public void produceStoreCode(CodeLines cls) {
		super.produceStoreCode(cls);
	}
	
	@Override
	public void produceCode(CodeLines cls) {
		super.produceCode(cls); // Gets the value of pointer on top of stack
		cls.add(new CodeLine(PMachineInstructions.IND)); // Perform indirection or dereferencing
	}

}

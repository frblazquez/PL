package ast;

import ast.arguments.ArgumentsDefinition;
import ast.expressions.Expression;
import ast.instructions.Instructions;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class MainFunction extends Function{

	public MainFunction(String id, ArgumentsDefinition args, Instructions insts, Type t, Expression e) {
		super(id, args, insts, t, e);
	}
	
	@Override
	public void produceCode(CodeLines cls) {
	cls.addMethod(identifier, cls.getNLines());
	cls.add(new CodeLine(PMachineInstructions.SSP, "" + this.staticDataSize()));
	cls.add(new CodeLine(PMachineInstructions.SEP, "" + this.stackEvaluationSize()));
	// Set dynamic and static links to zero
	cls.add(new CodeLine(PMachineInstructions.LDC, "0"));
	cls.add(new CodeLine(PMachineInstructions.STR, "0", "1"));
	cls.add(new CodeLine(PMachineInstructions.LDC, "0"));
	cls.add(new CodeLine(PMachineInstructions.STR, "0", "2"));
	
	// Set EP to zero
	cls.add(new CodeLine(PMachineInstructions.LDC, "0"));
	cls.add(new CodeLine(PMachineInstructions.STR, "0", "3"));
	// Set return value to instruction STP
	cls.add(new CodeLine(PMachineInstructions.LDC)); // Will be solved in the end
	int unsolvedline = cls.getNLines() - 1;
	cls.add(new CodeLine(PMachineInstructions.STR, "0", "4"));
	instructions.produceCode(cls);
	ret.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.RETF));
	cls.add(new CodeLine(PMachineInstructions.STP));
	cls.modify(unsolvedline, 1, cls.getNLines() - 1);	
	}
	
}

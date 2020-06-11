package ast.instructions;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Constant;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Case extends AstNode {

    private Constant exp;
    private Instructions ins;

    public Case(Constant e, Instructions is) {
	super(AstUtils.CASE_HEADER);
	exp = e;
	ins = is;

	children.add(exp);
	children.add(ins);
    }

    public Case(Instructions is) {
	super(AstUtils.DEFAULT_HEADER);
	exp = null;
	ins = is;

	children.add(ins);
    }

    public boolean isDefault() {
	return exp == null;
    }

    public Constant getConstantExpression() {
	return exp;
    }

    public Instructions getInstructions() {
	return ins;
    }

    @Override
    public void produceCode(CodeLines cls) {
	cls.add(new CodeLine(PMachineInstructions.DPL)); // Check if equals consumes a symbol
	exp.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.EQU));
	int caseCondition = cls.getNLines();
	cls.add(new CodeLine(PMachineInstructions.FJP)); 
	ins.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.UJP)); // Even last case finishes with unconditional Jump!
	int nextCase = cls.getNLines();

	cls.modify(caseCondition, nextCase);
    }
}

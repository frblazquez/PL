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

    @Override
    public void produceCode(CodeLines cls) {
	// TODO: Check this!
	// We duplicate the stack's last symbol so we can check if equals in next case
	// if it fails, this also means that when switch finishes we still have this
	// symbol in the stack!
	cls.add(new CodeLine(PMachineInstructions.DPL)); // Check if equals consumes a symbol!
	exp.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.EQU));
	cls.add(new CodeLine(PMachineInstructions.FJP, "TODO")); // TODO: Jump to next case!
	ins.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.UJP, "TODO")); // TODO: End of switch!
    }
}

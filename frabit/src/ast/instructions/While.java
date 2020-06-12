package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.BoolType;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class While extends Instruction {

    private Expression condition;
    private Instructions instructions;

    public While(Expression e, Instructions ins) {
	super(AstUtils.WHILE_HEADER);
	condition = e;
	instructions = ins;

	children.add(condition);
	children.add(instructions);
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	condition.checkSemantics(st);
	if (!condition.getType().equals(BoolType.BOOL_TYPE))
	    throw new SemanticErrorException("While condition must be a boolean expression", this.line);

	instructions.checkSemantics(st);
	this.st = st;
    }

    @Override
    public void produceCode(CodeLines cls) {
	int conditionEvaluationPC = cls.getNLines();
	condition.produceCode(cls);
	int conditionJumpPC = cls.getNLines();
	cls.add(new CodeLine(PMachineInstructions.FJP));
	instructions.produceCode(cls);
	int endWhileJumpPC = cls.getNLines();
	cls.add(new CodeLine(PMachineInstructions.UJP));
	int endPC = cls.getNLines();

	cls.modify(conditionJumpPC, endPC);
	cls.modify(endWhileJumpPC, conditionEvaluationPC);
    }
}

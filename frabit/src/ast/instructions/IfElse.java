package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.BoolType;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class IfElse extends Instruction {

    private Expression condition;
    private Instructions if_instructions;
    private Instructions else_instructions;

    public IfElse(Expression e, Instructions if_ins) {
	super(AstUtils.IF_HEADER);
	condition = e;
	if_instructions = if_ins;
	else_instructions = null;

	children.add(condition);
	children.add(if_ins);
    }

    public IfElse(Expression e, Instructions if_ins, Instructions else_ins) {
	super(AstUtils.IFELSE_HEADER);
	condition = e;
	if_instructions = if_ins;
	else_instructions = else_ins;

	children.add(condition);
	children.add(if_ins);
	children.add(else_ins);
    }

    public boolean hasElseClause() {
	return else_instructions != null;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	condition.checkSemantics(st);
	if (!condition.getType().equals(BoolType.BOOL_TYPE))
	    throw new SemanticErrorException("If condition must be a boolean expression", this.line);

	if_instructions.checkSemantics(st);
	if (this.hasElseClause())
	    else_instructions.checkSemantics(st);
	this.st = st;
    }

    @Override
    public void produceCode(CodeLines cls) {

	condition.produceCode(cls);
	int ifPC = cls.getNLines();
	cls.add(new CodeLine(PMachineInstructions.FJP));
	if_instructions.produceCode(cls);
	
	if (this.hasElseClause()) {
	    cls.add(new CodeLine(PMachineInstructions.UJP));
	    int elsePC = cls.getNLines();
	    else_instructions.produceCode(cls);
	    int endPC = cls.getNLines();

	    cls.modify(ifPC, 1, elsePC);
	    cls.modify(elsePC-1, 1, endPC);
	} else {
	    int endPC = cls.getNLines();
	    cls.modify(ifPC,1, endPC);
	}
    }
}

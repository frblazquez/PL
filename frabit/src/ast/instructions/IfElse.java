package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.BoolType;

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
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {

	condition.checkSemantics(st);

	if (!condition.getType().equals(BoolType.BOOL_TYPE))
	    throw new SemanticErrorException("If condition must be a boolean expression", this.line);

	if_instructions.checkSemantics(st);
	if (this.hasElseClause())
	    else_instructions.checkSemantics(st);

	return st;
    }
}

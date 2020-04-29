package ast.instructions;


import ast.AstUtils;
import ast.expressions.Expression;

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
}

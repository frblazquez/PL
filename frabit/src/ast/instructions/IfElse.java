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

	// TODO: Add condition to header or children when possible
	// children.add(base_expression);

	children.add(if_ins);
    }

    public IfElse(Expression e, Instructions if_ins, Instructions else_ins) {
	super(AstUtils.IFELSE_HEADER);
	condition = e;
	if_instructions = if_ins;
	else_instructions = else_ins;

	// TODO: Add condition to header or children when possible
	// children.add(base_expression);

	// TODO: If we don't define NODE_NAME attribute in AstNode as a final attribute
	// we could name here the If and Else instruction blocks in a more
	// representative way. Is it worth?
	// if_ins.setNodeName(AstUtils.IF_STATEMENTS_HEADER);

	children.add(if_ins);
	children.add(else_ins);
    }

    public boolean hasElseClause() {
	return else_instructions != null;
    }
}

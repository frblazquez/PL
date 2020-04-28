package ast.instructions;

import ast.AstUtils;
import ast.expressions.Expression;

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

}

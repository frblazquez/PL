package ast.instructions;

import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.access.VariableAccess;

public class Assignment extends Instruction {

    private VariableAccess variable;
    private Expression expression;

    public Assignment(VariableAccess va, Expression e) {
	super(AstUtils.ASSIGNMENT_HEADER);
	variable = va;
	expression = e;

	// TODO: Add the variable access and the expression when enabled
	// children.add(variable);
	// children.add(expression);
    }

}

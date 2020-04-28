package ast.instructions;

import java.util.List;

import ast.AstUtils;
import ast.expressions.Expression;

public class Switch extends Instruction {

    private Expression base_expression;
    private List<Case> cases;
    private Case default_case;

    public Switch(Expression exp, List<Case> cases, Case default_case) {
	super(AstUtils.SWITCH_HEADER);
	this.base_expression = exp;
	this.cases = cases;
	this.default_case = default_case;

	// TODO: Add base expression to header or children when possible
	// children.add(base_expression);

	children.addAll(cases);
	if (default_case != null)
	    children.add(default_case);
    }

    public Switch(Expression exp, List<Case> cases) {
	this(exp, cases, null);
    }

}

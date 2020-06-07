package ast.instructions;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Constant;

public class Case extends AstNode {

    private Constant exp;
    private Instructions ins;

    public Case(Constant e, Instructions is) {
	super(AstUtils.CASE_HEADER);
	exp = e;
	ins = is;

	children.add(e);
	children.add(is);
    }

    public Case(Instructions is) {
	super(AstUtils.DEFAULT_HEADER);
	exp = null;
	ins = is;

	children.add(is);
    }

    public boolean isDefault() {
	return exp == null;
    }

    public Constant getConstantExpression() {
	return exp;
    }
}

package ast.instructions;

import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;

public class Case extends AstNode {

    private Expression exp;
    private Instructions ins;

    public Case(Expression e, Instructions is) {
	super(AstUtils.CASE_HEADER);
	exp = e;
	ins = is;

	// TODO: Add expressions to header or to the children when possible
	// children.add(e);

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
    
}

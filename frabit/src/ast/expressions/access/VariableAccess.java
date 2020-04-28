package ast.expressions.access;

import java.util.List;

import ast.AstUtils;
import ast.expressions.Expression;

public class VariableAccess extends Expression {

    protected String identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	// TODO: This is not working because expressions are not properly configured!
	super(AstUtils.VAR_ACCESS_HEADER + "\"" + id + "\"");
	identifier = id;
	accesses = a;

	// TODO: Add accesses when enabled
	// children.addAll(accesses);
    }

    public String getIdentifier() {
	return identifier;
    }
}

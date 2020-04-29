package ast.expressions.access;

import java.util.List;

import ast.AstUtils;
import ast.expressions.Expression;

public class VariableAccess extends Expression {

    protected String identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	// TODO: Consider omitting header
	super(AstUtils.VAR_ACCESS_HEADER + id);
	identifier = id;
	accesses = a;
	children.addAll(accesses);
    }

    public String getIdentifier() {
	return identifier;
    }
}

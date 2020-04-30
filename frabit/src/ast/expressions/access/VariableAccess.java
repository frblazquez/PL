package ast.expressions.access;

import java.util.List;

import ast.expressions.Expression;

public class VariableAccess extends Expression {

    protected String identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	super(id);
	identifier = id;
	accesses = a;
	children.addAll(accesses);
    }

    public String getIdentifier() {
	return identifier;
    }
}

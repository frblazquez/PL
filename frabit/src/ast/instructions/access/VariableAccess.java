package ast.instructions.access;

import java.util.List;

public class VariableAccess {

    protected String identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	identifier = id;
	accesses = a;
    }

    public String getIdentifier() {
	return identifier;
    }
}

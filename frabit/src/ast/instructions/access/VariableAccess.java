package ast.instructions.access;

import java.util.List;

import ast.AstAux;

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
    
    public String astString(String prefix)
    {
    	String ret = AstAux.popLast(prefix) + "\\" + identifier;
    	
    	return ret;
    }
}

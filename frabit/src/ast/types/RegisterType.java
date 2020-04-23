package ast.types;

import java.util.List;

public class RegisterType extends Type {

    private List<Type> base_types;

    public RegisterType(List<Type> types) {
	base_types = types;
    }

    public String toString()
    {
    	String ret = "<";
    	boolean first = true;
    	for (Type t : base_types)
    	{
    		if (!first) ret += ",";
    		else first = false;
    		ret += t.toString();
    	}
    	return ret;
    }
}

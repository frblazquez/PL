package ast.types;

import java.util.Iterator;
import java.util.List;

import asem.SemanticErrorException;
import ast.AstUtils;

public class RegisterType extends Type {

    private List<Type> base_types;

    public RegisterType(List<Type> types) {
	super(AstUtils.REGISTER_HEADER);
	base_types = types;
	children.addAll(base_types);
    }
    
    public Type getEntryType(int index) throws SemanticErrorException
    {
    	int i = 0;
    	for(Iterator<Type> it = base_types.iterator(); it.hasNext(); ++i)
    	{
    		Type t = it.next();
    		if (i == index) return t;
    	}
    	throw new SemanticErrorException("Register access index out of bounds");
    }
}

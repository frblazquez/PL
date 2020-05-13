package ast.types;

import ast.AstNode;
import ast.AstUtils;

public class ArrayType extends Type {

    private Type base_type;
    private int size;

    public ArrayType(Type t, int n) {
	super(AstUtils.TYPE_HEADER + AstUtils.ARRAY_HEADER);
    	base_type = t;
    	size = n;

    	children.add(base_type);
	children.add(new AstNode(String.valueOf(size)));
    }
    
    public Type getBaseType()
	{
		return base_type;
	}
}

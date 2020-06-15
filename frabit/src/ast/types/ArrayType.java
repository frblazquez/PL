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

    public Type getBaseType() {
	return base_type;
    }

    @Override
    public boolean equals(Object o) {
	if (!(o instanceof ArrayType))
	    return false;

	ArrayType arr = ((ArrayType) o);
	return size == arr.size && base_type.equals(arr.base_type);
    }

    @Override
    public String toString() {
	return "[" + base_type + "," + size + "]";
    }

	@Override
	public int getSize() {
		// CAUTION: This is the total size (amount of mem words) that array takes, not its number of elements
		return size * base_type.getSize();
	}

    public Type getDeepestType() {
	if (base_type instanceof ArrayType)
	    return ((ArrayType) base_type).getDeepestType();
	else
	    return base_type;
    }
}

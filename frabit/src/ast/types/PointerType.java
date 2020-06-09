package ast.types;

import ast.AstUtils;

public class PointerType extends Type {

    public static final PointerType INT_PTR  = new PointerType(new IntType());
    public static final PointerType BOOL_PTR = new PointerType(new BoolType());
    
    private Type base_type;

    public PointerType() {
	super(AstUtils.TYPE_HEADER + AstUtils.POINTER_HEADER + AstUtils.POINTER_NULL);
	base_type = null;
    }

    public PointerType(Type t) {
	super(AstUtils.TYPE_HEADER + AstUtils.POINTER_HEADER);
	base_type = t;

	children.add(base_type);
    }

    @Override
    public boolean equals(Object o) {
	return (o instanceof PointerType) && base_type.equals(((PointerType) o).base_type);
    }

    @Override
    public String toString() {
	return "*" + base_type;
    }
}

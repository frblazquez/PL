package ast.types;

import ast.AstUtils;

public class PointerType extends Type {

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
}

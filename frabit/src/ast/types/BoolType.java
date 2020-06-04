package ast.types;

import ast.AstUtils;

public class BoolType extends Type {

    public static final BoolType BOOL_TYPE = new BoolType();

    public BoolType() {
	super(AstUtils.TYPE_HEADER + "bool");
    }

    @Override
    public boolean equals(Object o) {
	return o instanceof BoolType;
    }
}

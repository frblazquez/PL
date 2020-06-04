package ast.types;

import ast.AstUtils;

public class IntType extends Type {

    public static final IntType INT_TYPE = new IntType();

    public IntType() {
	super(AstUtils.TYPE_HEADER + "int");
    }

    @Override
    public boolean equals(Object o) {
	return o instanceof IntType;
    }
}

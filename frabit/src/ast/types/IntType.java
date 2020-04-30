package ast.types;

import ast.AstUtils;

public class IntType extends Type {

    public IntType() {
	super(AstUtils.TYPE_HEADER + "int");
    }
}

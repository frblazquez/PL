package ast.types;

import ast.AstUtils;

public class BoolType extends Type {

	public BoolType()
	{
		super(AstUtils.TYPE_HEADER + "bool");
	}
}

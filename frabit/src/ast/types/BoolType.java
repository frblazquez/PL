package ast.types;

import ast.AstUtils;
import ast.expressions.OperationTypes;

public class BoolType extends Type {

    public BoolType() 
    {
    	super(AstUtils.TYPE_HEADER + "bool");
    	this.op_type = OperationTypes.BOOLEAN;
    }
}

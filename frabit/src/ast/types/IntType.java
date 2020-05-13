package ast.types;

import ast.AstUtils;
import ast.expressions.OperationTypes;

public class IntType extends Type {

    public IntType() 
    {
    	super(AstUtils.TYPE_HEADER + "int");
    	this.op_type = OperationTypes.ARITHMETIC;
    }
}

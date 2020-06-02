package ast.types;

import ast.AstNode;
import ast.expressions.OperationTypes;

public abstract class Type extends AstNode {

    public Type(String header) {
	super(header);
    }
    OperationTypes op_type;
    
    public OperationTypes getOpType()
    {
    	return op_type;
    }

    // TODO: IMPORTANT!
    // Every subclass should implement it's "equals" method coherently with types
    // equivalences
}

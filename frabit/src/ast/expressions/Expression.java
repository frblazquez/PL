package ast.expressions;

import ast.AstNode;
import ast.types.Type;

public class Expression extends AstNode {
    protected Type expression_type;

    public Expression(String header) {
	super(header);
    }

    public Type getType() {
    	return expression_type;
    }
    
    @Override
    public int staticDataSize() {
	// Types do not require size, variables and blocks do
	return 0;
    }
}
package ast.expressions;

import ast.AstNode;
import ast.types.Type;

public class Expression extends AstNode {
    protected Type expression_type;

//    public Expression() {
//	expression_type = null;
//    }
//
//    public Expression(Type type) {
//	expression_type = type;
//    }

    public Expression(String header) {
	super(header);
    }
}
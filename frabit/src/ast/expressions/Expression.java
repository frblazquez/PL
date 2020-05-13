package ast.expressions;

import asem.SemanticErrorException;
import asem.SymbolTable;
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

    public Type getType(SymbolTable st) throws SemanticErrorException
    {
    	return expression_type;
    }
    
    public Expression(String header) {
	super(header);
    }
}
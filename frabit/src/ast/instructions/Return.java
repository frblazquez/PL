package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.Type;

public class Return extends AstNode {

    private Expression expression;

    public Return(Expression ret_expr) {
	super(AstUtils.RETURN_HEADER);
	expression = ret_expr;

	children.add(ret_expr);
    }

    public Type getReturnType(SymbolTable st) throws SemanticErrorException {
	return expression.getType();
    }

}

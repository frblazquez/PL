package ast.instructions;

import asem.SemanticErrorException;
import ast.AstNode;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Return extends AstNode {

    private Expression expression;

    public Return(Expression ret_expr) {
	super(AstUtils.RETURN_HEADER);
	expression = ret_expr;

	children.add(ret_expr);
    }

    public Type getReturnType() throws SemanticErrorException {
	return expression.getType();
    }

    @Override
    public void produceCode(CodeLines cls) {
	expression.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.STR, "0", "0"));
    }
}

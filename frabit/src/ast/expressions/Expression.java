package ast.expressions;

import ast.AstNode;
import ast.AstUtils;
import ast.types.Type;

public class Expression extends AstNode {

    // TODO: I think this should be Type instead of ExpressionTypes
    protected Type expression_type;

    public Expression() {
	expression_type = null;
    }

    public Expression(Type type) {
	expression_type = type;
    }

    public Expression(String header) {
	super(header);
    }

    // TODO: As we did with the types, we create internally the whole AST but we
    // don't want to print it to the last level, we print the expressions directly.

    // TODO: As it's implemented, it removes parentheses, the inner structure is ok.
    @Override
    public void astToString(StringBuilder sb, String prefix, String children_prefix) {
	sb.append(prefix);
	sb.append(AstUtils.EXPRESSION_HEADER);
	sb.append(this.toString());
	sb.append('\n');
    }
}
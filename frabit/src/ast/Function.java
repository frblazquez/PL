package ast;

import ast.arguments.ArgumentsDefinition;
import ast.expressions.Expression;
import ast.instructions.Instructions;
import ast.types.Type;

public class Function extends Procedure {

    private Expression return_expression;
    private Type return_type;

    public Function(String id, ArgumentsDefinition args, Instructions insts, Type t, Expression e) {
	super(AstUtils.FUNCTION_HEADER, id, args, insts);
	return_type = t;
	return_expression = e;

	// TODO: Add return expression when it has a proper astToString
	children.add(return_type);
    }
}

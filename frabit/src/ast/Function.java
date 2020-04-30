package ast;

import ast.arguments.ArgumentsDefinition;
import ast.expressions.Expression;
import ast.instructions.Instructions;
import ast.instructions.Return;
import ast.types.Type;

public class Function extends Procedure {
    private Return ret;
    private Type ret_type;
    
    public Function(String id, ArgumentsDefinition args, Instructions insts, Type t, Expression e) {
	super(AstUtils.FUNCTION_HEADER, id, args, insts);
	ret = new Return(e);
	ret_type = t;

	children.add(ret_type);
	children.add(ret);
    }
}

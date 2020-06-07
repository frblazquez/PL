package ast;

import asem.SemanticErrorException;
import asem.SymbolTable;
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
    
    @Override
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {
	// Arguments definition and instructions modify the ST inside the function
	SymbolTable func_st = arguments.checkSemantics(st);
	func_st = instructions.checkSemantics(func_st);
	ret.checkSemantics(func_st);

	if (!ret_type.equals(ret.getReturnType(func_st)))
	    throw new SemanticErrorException("Function type and return expression type do not match");

	// But when the function ends the scope has not been modified
    	return st;
    }
}

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
    
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	st = arguments.checkSemantics(st); // Arguments update symbol table
    	st = instructions.checkSemantics(st); // Get variables defined within instructions

	// TODO: IMPORTANT!
	// We are not checking the return expression has the function type!
    	ret.checkSemantics(st);
    	return st;
    }
}

package ast;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.arguments.ArgumentsDefinition;
import ast.expressions.Expression;
import ast.instructions.Instruction;
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
    
    public Type getType() {
	return ret_type;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	SymbolTable func_st = new SymbolTable(st);
	arguments.checkSemantics(func_st);
	
	for(Instruction i : instructions.getInstructions())
	    try{ i.checkSemantics(func_st);}
	    catch(SemanticErrorException e) {e.printSemanticError();}
	
	ret.checkSemantics(func_st);

	if (!ret_type.equals(ret.getReturnType()))
	    throw new SemanticErrorException("Function type and return expression type do not match");
	this.st = func_st;
    }
}

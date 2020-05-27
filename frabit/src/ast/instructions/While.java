package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.OperationTypes;

public class While extends Instruction {

    private Expression condition;
    private Instructions instructions;

    public While(Expression e, Instructions ins) {
	super(AstUtils.WHILE_HEADER);
	condition = e;
	instructions = ins;

	children.add(condition);
	children.add(instructions);
    }

    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	SymbolTable new_st = new SymbolTable(st); // While introduces new block
    	try 
    	{
    		condition.checkSemantics(new_st);
    		if (condition.getType(new_st).getOpType() != OperationTypes.BOOLEAN)
				throw new SemanticErrorException("Condition not a boolean",this.line);
    		instructions.checkSemantics(new_st);
    	}
    	catch (SemanticErrorException se)
    	{
    		se.printSemanticError();
    	}
    	return st; // After block is finished, same symbol table as before
    }
}

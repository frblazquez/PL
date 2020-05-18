package ast.instructions;


import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.OperationTypes;

public class IfElse extends Instruction {

    private Expression condition;
    private Instructions if_instructions;
    private Instructions else_instructions;

    public IfElse(Expression e, Instructions if_ins) {
	super(AstUtils.IF_HEADER);
	condition = e;
	if_instructions = if_ins;
	else_instructions = null;

	children.add(condition);
	children.add(if_ins);
    }

    public IfElse(Expression e, Instructions if_ins, Instructions else_ins) {
	super(AstUtils.IFELSE_HEADER);
	condition = e;
	if_instructions = if_ins;
	else_instructions = else_ins;

	children.add(condition);
	children.add(if_ins);
	children.add(else_ins);
    }

    public boolean hasElseClause() {
	return else_instructions != null;
    }
    
    public SymbolTable checkSemantics(SymbolTable st)
    {
    	SymbolTable new_st = new SymbolTable(st); // If introduces new block
    	try 
    	{
    		condition.checkSemantics(new_st);
    		if (condition.getType(new_st).getOpType() != OperationTypes.BOOLEAN)
				throw new SemanticErrorException("Condition not a boolean");
    		if_instructions.checkSemantics(new_st);
    		if (this.hasElseClause())
    		{
    			SymbolTable else_st = new SymbolTable(st); // Else introduces new block
    			else_instructions.checkSemantics(else_st);
    		}
    	}
    	catch (SemanticErrorException se)
    	{
    		se.printSemanticError();
    	}
    	
    	return st;
    }
}

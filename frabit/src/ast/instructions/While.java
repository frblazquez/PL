package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.BoolType;

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

    @Override
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {
	condition.checkSemantics(st);
	if (!condition.getType().equals(BoolType.BOOL_TYPE))
	    throw new SemanticErrorException("While condition must be a boolean expression", this.line);
	instructions.checkSemantics(st);
	return st; // After block is finished, same symbol table as before
    }
}

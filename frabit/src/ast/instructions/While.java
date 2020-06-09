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
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	// Important! Check semantics for an expression won't modify the symbol table
	condition.checkSemantics(st);
	if (!condition.getType().equals(BoolType.BOOL_TYPE))
	    throw new SemanticErrorException("While condition must be a boolean expression", this.line);

	instructions.checkSemantics(st);
	this.st = st;
    }
}

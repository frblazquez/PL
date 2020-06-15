package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.access.VariableAccess;
import ast.types.IntType;
import ast.types.PointerType;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class New extends Instruction{
	private VariableAccess va;
	private Expression size;
	
	public New(VariableAccess va, Expression size) {
	super(AstUtils.NEW_HEADER);
	this.children.add(va);
	this.children.add(size);
	this.va = va;
	this.size = size;
	}
	
	@Override
	public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	super.checkSemantics(st);
	Type type = va.getType();
	if (!(type instanceof PointerType))
	    throw new SemanticErrorException("First argument of \"new\" instruction must be a pointer", this.line);
	
	if (!size.getType().equals(IntType.INT_TYPE))
	    throw new SemanticErrorException("Second argument of \"new\" instruction must be the size of the memory block", this.line);
	this.st = st;
	}
	
	@Override
	public void produceCode(CodeLines cls) {
	// Push pointer's address on stack, so it can save NP
	va.produceStoreCode(cls);
	// Evaluate size and update NP
	size.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.NEW)); 
	}
}

package ast.instructions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Expression;
import ast.expressions.access.VariableAccess;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;
import ast.types.BoolType;
import ast.types.IntType;
import ast.types.PointerType;

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
		throw new SemanticErrorException("First argument of new must be a pointer", this.line);
	
	PointerType pt = (PointerType) type;
	if (!pt.getBaseType().equals(IntType.INT_TYPE) && !pt.getBaseType().equals(BoolType.BOOL_TYPE))
		throw new SemanticErrorException("Pointer in new must point at primitive types", this.line);
	
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

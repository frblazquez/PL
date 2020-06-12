package ast.expressions.access;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.types.PointerType;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Dereferencing extends VariableAccess {
	public Dereferencing(VariableAccess va) {
		super(va.identifier.toString(), va.accesses);
	}
	
	public Dereferencing(String id, List<Access> a) {
		super(id,a);
	}
	
	@Override
	public void produceStoreCode(CodeLines cls) {
		super.produceStoreCode(cls);
		cls.add(new CodeLine(PMachineInstructions.IND));
		// Note that this first indirection gets address that pointer stores on stack
	}
	
	@Override
	public void produceCode(CodeLines cls) {
		this.produceStoreCode(cls);
		int size = expression_type.getSize();
		cls.add(new CodeLine(PMachineInstructions.MOVS, Integer.toString(size)));
	}

	@Override
	public void checkSemantics(SymbolTable st) throws SemanticErrorException {
		super.checkSemantics(st);
		if (!(this.expression_type instanceof PointerType))
			throw new SemanticErrorException("Can only dereference pointers", this.line);
		
		this.expression_type = ((PointerType) this.expression_type).getBaseType();
	}
}

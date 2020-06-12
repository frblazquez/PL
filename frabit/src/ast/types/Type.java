package ast.types;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstNode;

public abstract class Type extends AstNode {

    public Type(String header) {
	super(header);
    }
    
    public int getSize() { return 1; }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	this.st = st;
    }

    @Override
    public int staticDataSize() {
	// Types do not require size, variables do
	return 0;
    }

    public int stackEvaluationSize() {
	// Types do not require stack size
	return 0;
    }
}

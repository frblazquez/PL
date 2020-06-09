package ast.types;

import ast.AstNode;

public abstract class Type extends AstNode {

    public Type(String header) {
	super(header);
    }
    
    public int getSize() { return 1; }

}

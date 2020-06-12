package ast.instructions;

import ast.AstNode;

public class Instruction extends AstNode {

    /**
     * Constructor designed to be a bridge with AstNode class.
     */
    public Instruction(String header) {
	super(header);
    }
}

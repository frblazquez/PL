package ast.instructions;

import java.util.ArrayList;
import java.util.List;

import ast.AstNode;
import ast.AstUtils;

public class Instructions extends AstNode {

    protected List<Instruction> instructions;

    public Instructions() {
	super(AstUtils.INSTRUCTIONS_HEADER);
	instructions = new ArrayList<Instruction>();
    }

    public void add(Instruction instr) {
	instructions.add(instr);
	children.add(instr);
    }
}

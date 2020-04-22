package ast.instructions;

import java.util.List;

import ast.Expression;

public class While extends Instruction {

    private Expression condition;
    private List<Instruction> instructions;

    public While(Expression e, List<Instruction> ins) {
	condition = e;
	instructions = ins;
    }

}

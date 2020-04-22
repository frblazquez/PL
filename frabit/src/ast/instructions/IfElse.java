package ast.instructions;

import java.util.List;

import ast.Expression;

public class IfElse extends Instruction {

    private Expression condition;
    private List<Instruction> if_instructions;
    private List<Instruction> else_instructions;

    public IfElse(Expression e, List<Instruction> if_ins) {
	condition = e;
	if_instructions = if_ins;
	else_instructions = null;
    }

    public IfElse(Expression e, List<Instruction> if_ins, List<Instruction> else_ins) {
	condition = e;
	if_instructions = if_ins;
	else_instructions = else_ins;
    }

    public boolean hasElseClause() {
	return else_instructions != null;
    }
}

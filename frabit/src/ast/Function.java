package ast;

import java.util.List;
import java.util.Map;

import ast.instructions.Instruction;
import ast.types.Type;

public class Function extends Procedure {

    private Expression return_expression;
    private Type return_type;

    // TODO: Remove constructor when possible
    public Function(String id, List<Instruction> insts) {
	super(id, insts);
    }

    // TODO: Remove constructor when possible
    public Function(String id, List<Instruction> insts, Type t, Expression e) {
	super(id, insts);
	return_type = t;
	return_expression = e;
    }

    public Function(String id, Map<String, Type> args, List<Instruction> insts, Type t, Expression e) {
	super(id, args, insts);
	return_type = t;
	return_expression = e;
    }

}

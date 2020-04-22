package ast;

import java.util.List;
import java.util.Map;

import ast.instructions.Instruction;
import ast.types.Type;

public class Procedure {

    protected String identifier;
    protected List<Instruction> instructions;
    protected Map<String, Type> arguments;

    // TODO: Remove constructor when possible
    public Procedure(String id, List<Instruction> insts) {
	identifier = id;
	instructions = insts;
    }

    public Procedure(String id, Map<String, Type> args, List<Instruction> insts) {
	identifier = id;
	instructions = insts;
	arguments = args;
    }

}

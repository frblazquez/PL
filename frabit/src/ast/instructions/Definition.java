package ast.instructions;

import ast.Expression;
import ast.types.Type;

public class Definition extends Instruction {

    private Type type;
    private String identifier;
    private Expression initialization;

    public Definition(Type t, String id) {
	type = t;
	identifier = id;
    }

    public Definition(Type t, String id, Expression e) {
	type = t;
	identifier = id;
	initialization = e;
    }
}

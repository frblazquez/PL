package ast.instructions;

import ast.AstUtils;
import ast.expressions.Expression;
import ast.types.Type;

public class Definition extends Instruction {

    private Type type;
    private String identifier;
    private Expression initialization;

    public Definition(Type t, String id) {
	this(t, id, null);
    }

    public Definition(Type t, String id, Expression e) {
	super(AstUtils.DEFINITION_HEADER + "\"" + id + "\"");
	type = t;
	identifier = id;
	initialization = e;

	children.add(t);

	// TODO: Again reconsider the possibility of placing the identifier as a child
	// instead of placing it at the header
	// children.add(id);

	// TODO: Add the initialization (if not null!) when it has a proper astToString
	// children.add(e);

    }
}

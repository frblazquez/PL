package ast.instructions;

import ast.AstUtils;
import ast.Identifier;
import ast.expressions.Expression;
import ast.types.Type;

public class Definition extends Instruction {

    private Type type;
    private Identifier identifier;
    private Expression initialization;

    public Definition(Type t, String id) {
	this(t, id, null);
    }

    public Definition(Type t, String id, Expression e) {
	super(AstUtils.DEFINITION_HEADER);
	type = t;
	identifier = new Identifier(id);
	initialization = e;

	children.add(t);
	children.add(identifier);
	if (e != null)
	    children.add(e);
    }
}

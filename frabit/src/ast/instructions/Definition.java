package ast.instructions;

import ast.AstNode;
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
	super(AstUtils.DEFINITION_HEADER);
	type = t;
	identifier = id;
	initialization = e;

	children.add(t);
	children.add(new AstNode(AstUtils.ID_HEADER + id));

	if (e != null)
	    children.add(e);

    }
}

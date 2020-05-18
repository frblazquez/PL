package ast.arguments;

import ast.AstNode;
import ast.AstUtils;
import ast.Identifier;
import ast.types.Type;

public class PairArgumentType extends AstNode {

    private Identifier identifier;
    private Type type;

    public PairArgumentType(String id, Type t) {
    	super(AstUtils.PARAM_HEADER);
	identifier = new Identifier(id);
    	type = t;
    	
	children.add(identifier);
    	children.add(type);
    }
    
    public Identifier getIdentifier()
    {
    	return identifier;
    }
    
    public Type getType()
    {
    	return type;
    }

}

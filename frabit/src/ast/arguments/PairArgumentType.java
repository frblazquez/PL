package ast.arguments;

import ast.AstNode;
import ast.AstUtils;
import ast.types.Type;

public class PairArgumentType extends AstNode {

    private String identifier;
    private Type type;

    public PairArgumentType(String id, Type t) {
    	super(AstUtils.PARAM_HEADER);
    	
    	identifier = id;
    	type = t;
    	
    	children.add(type);
    	children.add(new AstNode(AstUtils.ID_HEADER + identifier));
    }

//    @Override
//    public void astToString(StringBuilder sb, String prefix, String children_prefix) {
//	sb.append(prefix);
//	sb.append(AstUtils.ID_HEADER);
//	sb.append(identifier);
//	sb.append(", ");
//	sb.append(AstUtils.TYPE_HEADER);
//	sb.append(type.toString());
//	sb.append('\n');
//    }

}

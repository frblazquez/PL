package ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is responsible of the tree structure and functionalities behind
 * our AST generation from valid programs for our syntax.
 */
public class AstNode {
    
    protected final String NODE_NAME;
    protected List<AstNode> children;
    
    public AstNode(String node_name) {
	NODE_NAME = node_name;
	children = new ArrayList<AstNode>();
    }

    // TODO: Remove constructor when possible. More important than what it seems.
    public AstNode() {
	NODE_NAME = "NULL";
	children = null;
    }


    /**
     * This method should be valid for all non-leaf nodes. Varying NODE_NAME
     * attribute and the insertion order in children list should be enough.
     * 
     */
    public void astToString(StringBuilder sb, String prefix, String children_prefix) {
	sb.append(prefix);
	sb.append(NODE_NAME);
	sb.append('\n');

	if(children != null && !children.isEmpty()) {
	    for (Iterator<AstNode> it = children.iterator(); it.hasNext();) {
	            AstNode next = it.next();
	            if (it.hasNext()) {
	                next.astToString(sb, children_prefix + AstUtils.NEW_BRANCH_DELIMITER, children_prefix + AstUtils.INNER_SEPARATION);
	            } else {
	        	next.astToString(sb, children_prefix + AstUtils.LAST_BRANCH_DELIMITER, children_prefix + AstUtils.BLANK_SEPARATION);
	            }
	        }
	}
    }

}

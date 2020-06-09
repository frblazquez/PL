package ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import code.CodeLines;

/**
 * This class is responsible of the tree structure and functionalities behind
 * our AST generation from valid programs for our syntax.
 */
public class AstNode {
    
    protected final String NODE_NAME;
    protected List<AstNode> children;
    protected int line;
    protected SymbolTable st;
    
    public AstNode(String node_name) {
	NODE_NAME = node_name;
	children = new ArrayList<AstNode>();
	line = -1; // TODO: Set lines from cup file
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
	            if (next == null) continue;
	            if (it.hasNext()) {
	                next.astToString(sb, children_prefix + AstUtils.NEW_BRANCH_DELIMITER, children_prefix + AstUtils.INNER_SEPARATION);
	            } else {
	        	next.astToString(sb, children_prefix + AstUtils.LAST_BRANCH_DELIMITER, children_prefix + AstUtils.BLANK_SEPARATION);
	            }
	        }
	}
    }
    
    /**
     * Takes a symbol table, checks the semantics of a certain piece of code and
     * updates the symbol table according with the instructions.
     * 
     * @param st Symbol table with current program scope, w be modified
     * @throws SemanticErrorException
     */
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
    	for (AstNode node: children){
    	    if (node == null) continue; // Could be syntactic errors
    		
	    try { node.checkSemantics(st); }
    	    catch (SemanticErrorException se) { se.printSemanticError();}
    	}
    	this.st = st;
    }
    
    public CodeLines produceCode() {
    	CodeLines ret = new CodeLines();
    	for (Iterator<AstNode> it = children.iterator(); it.hasNext();)
    	{
    		AstNode next = it.next();
    		ret.addAll(next.produceCode());
    	}
    	return ret;
    }
    
    public void setLine(int line) { this.line = line; }
    public int getLine() 	  { return line; }
}

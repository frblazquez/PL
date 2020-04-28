package ast.types;

import ast.AstNode;
import ast.AstUtils;

public class Type extends AstNode {

    // TODO: Should types be part of the AST (and extend AstToString) or we consider
    // that it's enough with having their toString() method?

    @Override
    public void astToString(StringBuilder sb, String prefix, String children_prefix) {
	sb.append(prefix);
	sb.append(AstUtils.TYPE_HEADER);
	sb.append(this.toString());
	sb.append('\n');
    }
}

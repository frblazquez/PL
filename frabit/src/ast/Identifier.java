package ast;

public class Identifier extends AstNode {

    private String identifier;

    public Identifier(String id) {
	super(AstUtils.ID_HEADER + id);
	identifier = id;
    }

    @Override
    public String toString() {
	return identifier;
    }

}

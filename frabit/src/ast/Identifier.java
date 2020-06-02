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
    
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Identifier)) {
            return false;
        }

        Identifier id = (Identifier) o;

	// Instances of same class can access private members of each other
        return id.identifier.equals(identifier);
    }
    
    @Override
    public int hashCode()
    {
    	return identifier.hashCode();
    }
}

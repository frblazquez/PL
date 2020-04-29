package ast.expressions.access;

public class RegisterAccess extends Access {

    private int index;

    public RegisterAccess(int idx) {
    	super("." + idx);
    	index = idx;
    }
    
    @Override
    public String toString() {
	return "." + index;
    }
}

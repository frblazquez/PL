package ast.instructions.access;

public class RegisterAccess extends Access {

    private int index;

    public RegisterAccess(int idx) {
	index = idx;
    }

}

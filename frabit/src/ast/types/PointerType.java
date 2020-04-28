package ast.types;

public class PointerType extends Type {

    private Type base_type;

    public PointerType(Type t) {
	base_type = t;
    }

    @Override
    public String toString() {
	return "*" + base_type.toString();
    }
}

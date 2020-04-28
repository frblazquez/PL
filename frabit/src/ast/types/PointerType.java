package ast.types;

public class PointerType extends Type {

    private Type base_type;

    // TODO: Dangerous but necessary for instantiating NULL constant type!
    public PointerType() {
	base_type = null;
    }

    public PointerType(Type t) {
	base_type = t;
    }

    @Override
    public String toString() {
	return "*" + base_type.toString();
    }
}

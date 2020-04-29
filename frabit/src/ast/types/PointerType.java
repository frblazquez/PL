package ast.types;

public class PointerType extends Type {

    private Type base_type;

    // TODO: Dangerous but necessary for instantiating NULL constant type!
    public PointerType() {
    super("null");
	base_type = null;
    }

    public PointerType(Type t) {
	// TODO: Consider changing this for a POINTER header
	super("*");
	base_type = t;
	children.add(base_type);
    }
}

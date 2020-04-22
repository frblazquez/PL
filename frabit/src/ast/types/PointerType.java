package ast.types;

public class PointerType extends Type {

    private Type base_type;

    public PointerType(Type t) {
	base_type = t;
    }

}

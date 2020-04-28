package ast.types;

public class ArrayType extends Type {

    private Type base_type;
    private int size;

    public ArrayType(Type t, int n) {
	base_type = t;
	size = n;
    }
    
    @Override
    public String toString() {
	return "[" + base_type.toString() + "," + size + "]";
    }
}

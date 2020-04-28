package ast.types;

import java.util.List;

public class RegisterType extends Type {

    private List<Type> base_types;

    public RegisterType(List<Type> types) {
	base_types = types;
    }

    @Override
    public String toString() {
	String aux = base_types.toString();
	aux = aux.substring(1, aux.length() - 1);
	return "<" + aux + ">";
    }
}

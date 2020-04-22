package ast.types;

import java.util.List;

public class RegisterType extends Type {

    private List<Type> base_types;

    public RegisterType(List<Type> types) {
	base_types = types;
    }

}

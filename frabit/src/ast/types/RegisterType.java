package ast.types;

import java.util.List;

import ast.AstUtils;

public class RegisterType extends Type {

    private List<Type> base_types;

    public RegisterType(List<Type> types) {
	super(AstUtils.REGISTER_HEADER);
	base_types = types;
	children.addAll(base_types);
    }
    
    public Type getEntryType(int index) {
	return base_types.get(index);
    }

    @Override
    public boolean equals(Object o) {
	return (o instanceof RegisterType) && base_types.equals(((RegisterType) o).base_types);
    }
}

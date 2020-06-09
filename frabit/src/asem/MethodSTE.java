package asem;

import java.util.List;

import ast.types.Type;

public class MethodSTE extends SymbolTableEntry {
    private int number_of_arguments;
    private List<Type> types_of_arguments;

    public MethodSTE(int noa, List<Type> toa) {
	super(null);
	number_of_arguments = noa;
	types_of_arguments = toa;
    }

    public MethodSTE(int noa, List<Type> toa, Type returnType) {
	super(returnType);
	number_of_arguments = noa;
	types_of_arguments = toa;
    }
    public int getNumberOfArguments() 	    { return this.number_of_arguments; }
    public List<Type> getTypesOfArguments() { return this.types_of_arguments; }

}

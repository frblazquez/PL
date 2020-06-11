package asem;

import java.util.List;

import ast.types.Type;

public class MethodSTE extends SymbolTableEntry {
    private int number_of_arguments;
    private List<Type> types_of_arguments;

    // TODO: I don't like this at all
    public MethodSTE(int noa, List<Type> toa) {
	super(-1, null);
	number_of_arguments = noa;
	types_of_arguments = toa;
    }

    public MethodSTE(int noa, List<Type> toa, Type returnType) {
	super(-1, returnType);
	number_of_arguments = noa;
	types_of_arguments = toa;
    }
    public int getNumberOfArguments() 	    { return this.number_of_arguments; }
    
    public int getSizeOfArguments() {
	int size = 0;
	for (Type t : types_of_arguments) {
		size += t.getSize();
	}
	return size;
    }
    
    public List<Type> getTypesOfArguments() { return this.types_of_arguments; }

}

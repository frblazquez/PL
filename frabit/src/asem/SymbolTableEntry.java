package asem;

import ast.types.Type;

public class SymbolTableEntry {
    protected int memaddr;
    protected Type type;

    public SymbolTableEntry(int memaddr, Type type) {
	this.memaddr = memaddr;
	this.type = type;
    }

    public int getAddr() {
	return memaddr;
    }

    public Type getType() {
	return type;
    }
}

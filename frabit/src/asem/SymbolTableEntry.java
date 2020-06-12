package asem;

import ast.types.Type;

public class SymbolTableEntry {
    protected int memaddr;
    protected Type type;

    public SymbolTableEntry(Type type) {
	this.type = type;
    }

    public int getAddr() {
	return memaddr;
    }

    public Type getType() {
	return type;
    }

    public void setMemAddress(int addr) {
	memaddr = addr;
    }
}

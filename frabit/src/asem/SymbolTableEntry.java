package asem;

import ast.types.Type;

public class SymbolTableEntry {
    protected MemoryAddress memaddr;
    protected Type type;

    public SymbolTableEntry() {
	memaddr = new MemoryAddress();
	type = null;
    }

    public SymbolTableEntry(Type type) {
	this.memaddr = new MemoryAddress();
	this.type = type;
    }

    public SymbolTableEntry(MemoryAddress memaddr, Type type) {
	this.memaddr = memaddr;
	this.type = type;
    }

    public MemoryAddress getAddr() { return memaddr; }
    public Type getType()          { return type;    }
}

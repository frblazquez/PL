package asem;

import ast.types.Type;

// TODO: MemoryAddress?? This class should fully make sense at pcode generation stage
public class SymbolTableEntry {
    private MemoryAddress memaddr;
    private Type type;

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

package asem;

import ast.types.Type;

public class SymbolTableEntry {
    protected int memaddr;
    protected int mempositions;
    protected Type type;

    public SymbolTableEntry() {
	memaddr = -1;
	type = null;
    }

    public SymbolTableEntry(Type type) {
	memaddr = -1;
	this.type = type;
    }

    public SymbolTableEntry(int memaddr, Type type) {
	memaddr = -1;
	this.type = type;
    }

    public SymbolTableEntry(Type type, int memaddr, int mempositions) {
	this.type = type;	
	this.memaddr = memaddr;
	this.mempositions = mempositions;
	}

	public int getAddr() { return memaddr; }
    public Type getType()          { return type;    }
}

package asem;

import ast.types.Type;

public class SymbolTableEntry {
	private MemoryAddress memaddr;
	private Type type;
	
	
	// TODO: More items might be needed in symbol table (e.g. memory address)
	public SymbolTableEntry() 
	{
		memaddr = new MemoryAddress();
		type = null;
	}
	
	public SymbolTableEntry(MemoryAddress memaddr, Type type) 
	{
		super();
		this.setMemAddr(memaddr);
		this.setType(type);
	}
	
	public void setMemAddr(MemoryAddress memaddr)
	{
		this.memaddr = memaddr;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
	public MemoryAddress getAddr()
	{
		return  memaddr;
	}
	
	public Type getType()
	{
		return type;
	}
}

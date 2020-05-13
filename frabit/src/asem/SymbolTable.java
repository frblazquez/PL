package asem;

import java.util.HashMap;
import java.util.Map.Entry;

import ast.Identifier;

public final class SymbolTable {

	protected HashMap<Identifier,SymbolTableEntry> bindings;
	protected SymbolTable prevBlockST;
	
    public SymbolTable() 
    {
    	bindings = new HashMap<Identifier,SymbolTableEntry>();
    }
    
    public SymbolTable(SymbolTable prev)
    {
    	prevBlockST = prev;
    }
    
    public boolean contains(Identifier id)
    {
    	if (prevBlockST != null)
    		return bindings.containsKey(id) || prevBlockST.bindings.containsKey(id);
    	else return bindings.containsKey(id);
    }
    
    public SymbolTableEntry get(Identifier id) throws SemanticErrorException
    {
    	// Make access to this level preferent
    	if (bindings.containsKey(id))
		{
    		return bindings.get(id);
		}
    	else if (prevBlockST != null && prevBlockST.contains(id))	// If not in innermost block search in outer blocks
		{
    		return prevBlockST.get(id);
		}
    	else
    	{
    		throw new SemanticErrorException("Identifier not declared: " + id);
    	}
    }
    
    public void makeBinding(Identifier id, SymbolTableEntry ste) throws SemanticErrorException
    {
    	// Check id is not bound to any entry in this level
    	if (bindings.containsKey(id))
    	{
    		throw new SemanticErrorException("Repeated identifier in block: " + id.toString());
    	}
    	bindings.put(id, ste);
    }
    
    // TODO: Consider removing this
    public String toString()
    {
    	StringBuilder sb = new StringBuilder("");
    	for (Entry<Identifier, SymbolTableEntry> i : bindings.entrySet())
		{
    		sb.append(i.getKey().toString() + " ");
    		sb.append(i.getValue().toString() + "\n");
		}
    	return sb.toString();
    }
}

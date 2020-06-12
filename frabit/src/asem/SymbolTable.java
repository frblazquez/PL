package asem;

import java.util.HashMap;

import ast.Identifier;
import ast.Procedure;

public final class SymbolTable {

    protected static HashMap<Identifier, Procedure> methods = new HashMap<Identifier, Procedure>();
    protected HashMap<Identifier, SymbolTableEntry> bindings;
    protected SymbolTable prevBlockST;
    protected int next_free_address;

    public SymbolTable() {
	next_free_address = 5; // Five addresses reserved for activation frame
	bindings = new HashMap<Identifier, SymbolTableEntry>();
	prevBlockST = null;
    }

    public SymbolTable(SymbolTable prev) {
	next_free_address = prev.getNextFreeAddress();
	bindings = new HashMap<Identifier, SymbolTableEntry>();
	prevBlockST = prev;
    }

    public boolean contains(Identifier id) {
	return bindings.containsKey(id) || (prevBlockST != null && prevBlockST.contains(id));
    }

    public SymbolTableEntry get(Identifier id) throws SemanticErrorException {
	if (bindings.containsKey(id))
	    return bindings.get(id);
	else if (prevBlockST != null)
	    return prevBlockST.get(id);
	else
	    throw new SemanticErrorException("Identifier not declared: " + id);
    }

    // Same as above but no exception guaranteed
    public SymbolTableEntry getCertain(Identifier id) {
    	if (bindings.containsKey(id))
    		return bindings.get(id);
    	else if (prevBlockST != null)
    	    return prevBlockST.getCertain(id);
    	else 
    		return null;
    }
    
    public void makeBinding(Identifier id, SymbolTableEntry ste) throws SemanticErrorException {
	if (bindings.containsKey(id))
	    throw new SemanticErrorException("Repeated identifier in block", id.getLine());
	
	ste.setMemAddress(next_free_address);
	next_free_address += ste.getType().getSize();

	bindings.put(id, ste);
    }

    public int getNextFreeAddress() { return this.next_free_address; }

    public void addMethod(Procedure p) {
	methods.put(p.getIdentifier(), p);
    }

    public Procedure getMethod(Identifier id) {
	return methods.get(id);
    }

    public boolean containsMethod(Identifier id) {
	return methods.containsKey(id);
    }
}

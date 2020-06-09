package asem;

import java.util.HashMap;

import ast.Identifier;

public final class SymbolTable {

    protected HashMap<Identifier, SymbolTableEntry> bindings;
    protected SymbolTable prevBlockST;

    public SymbolTable() {
	bindings = new HashMap<Identifier, SymbolTableEntry>();
	prevBlockST = null;
    }

    public SymbolTable(SymbolTable prev) {
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

    public void makeBinding(Identifier id, SymbolTableEntry ste) throws SemanticErrorException {
	if (bindings.containsKey(id))
	    System.out.println("Semantic  warn on line "+id.getLine()+": Identifier \"" + id + "\" will be overwritten");

	bindings.put(id, ste);
    }

}

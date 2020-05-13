package ast.expressions.access;

import java.util.Iterator;
import java.util.List;

import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.Identifier;
import asem.SemanticErrorException;
import ast.expressions.Expression;
import ast.types.ArrayType;
import ast.types.RegisterType;
import ast.types.Type;

public class VariableAccess extends Expression {

    protected Identifier identifier;
    protected List<Access> accesses;

    public VariableAccess(String id, List<Access> a) {
	super(id);
	identifier = new Identifier(id);
	accesses = a;
	children.addAll(accesses);
    }

    public Identifier getIdentifier() {
	return identifier;
    }
    
    public Type getType(SymbolTable st) throws SemanticErrorException
    {
    	SymbolTableEntry ste = st.get(identifier); 
    	if (ste ==  null)
    	{
    		System.out.println("WE HAD A NULL\n" + st.toString());
    	}
    	Type t = ste.getType();
    	for (Iterator<Access> it = accesses.iterator(); it.hasNext(); )
    	{
    		Access ac = it.next();
    		if (t instanceof ArrayType && ac instanceof ArrayAccess)
    		{
    			t = ((ArrayType) t).getBaseType();
    		}
    		else if (t instanceof RegisterType && ac instanceof RegisterAccess)
    		{
    			RegisterType taux = (RegisterType) t;
    			RegisterAccess acaux = (RegisterAccess) ac;
    			t = taux.getEntryType(acaux.getIndex());
    		}
    		else throw new SemanticErrorException("Illegal access " + ac.toString());
    	}
    	return t;
    }
}

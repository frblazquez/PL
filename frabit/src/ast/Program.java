package ast;

import java.util.Iterator;
import java.util.List;

import asem.MethodSTE;
import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;

public class Program extends AstNode {

    // We keep full references for later stages of development. For the moment it's
    // only necessary to deal with AstNode instances.
    private List<Procedure> methods;
    private Function main_function;

    public Program(List<Procedure> methods, Function main) {
	super(AstUtils.PROGRAM_HEADER);
	this.methods = methods;
	this.main_function = main;

	children.addAll(methods);
	children.add(main);

	// TODO: We allow to create invalid semantic Program instances. Do you agree? If
	//       not, check semantics here.
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	astToString(sb, "", "");
	return sb.toString();
    }
    
    @Override
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {	
    	st.makeBinding(new Identifier("main"), new SymbolTableEntry());
    	for (Iterator<Procedure> it = methods.iterator(); it.hasNext();)
    	{
    		Procedure p = it.next();
    		if (st.contains(p.getIdentifier()))
    		{
    			throw new SemanticErrorException("Cannot have two functions with same name",p.getLine());
    		}
    		else
    		{
    		    	// TODO: It might be better (safer) a builder instead instantiate and set
    			MethodSTE ste = new MethodSTE();
    			ste.setNumberOfArguments(p.getNumberOfArguments());
    			ste.setTypesOfArguments(p.getArgumentTypes());
    			
    			// TODO: IMPORTANT!
    			// This way we only allow to invoke previously defined methods. Shouldn't we
    			// allow mutual recursion?
    			st.makeBinding(p.getIdentifier(), ste);
    			try
    			{
    				p.checkSemantics(st);
    			}
    			catch (SemanticErrorException se)
    			{
    				se.printSemanticError();
    			}
    		}
    	}
    	main_function.checkSemantics(st); // Check main semantics last, after all functions added to scope
    	return st;
    }
}

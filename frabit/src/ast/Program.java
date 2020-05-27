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
	try
	{
		this.checkSemantics(new SymbolTable());
	}
	catch (SemanticErrorException | NullPointerException e)
	{
		e.printStackTrace();
		System.out.println("Semantic error found: " + e.getMessage());
	}
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	astToString(sb, "", "");
	return sb.toString();
    }
    
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
    			MethodSTE ste = new MethodSTE();
    			ste.setNumberOfArguments(p.getNumberOfArguments());
    			ste.setTypesOfArguments(p.getArgumentTypes());
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

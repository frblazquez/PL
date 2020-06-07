package ast;

import java.util.List;

import asem.MethodSTE;
import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;

public class Program extends AstNode {

    private List<Procedure> methods;
    private Function main_function;

    public Program(List<Procedure> methods, Function main) {
	super(AstUtils.PROGRAM_HEADER);
	this.methods = methods;
	this.main_function = main;

	children.addAll(methods);
	children.add(main);
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	astToString(sb, "", "");
	return sb.toString();
    }

    @Override
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {
	// TODO: IMPORTANT!
	// Do we allow to invoke main function? 
	//   + If so it's SymbolTableEntry should be properly initialized
	//   + If not we shouldn't make it's binding and we shouldn't allow to add a method called "main"
	st.makeBinding(new Identifier("main"), new SymbolTableEntry());

	for(Procedure p : methods) {
	    if (st.contains(p.getIdentifier()))
		throw new SemanticErrorException("Two methods can not have the same identifier \""+p.getIdentifier()+"\"", p.getLine());
	    else {
		MethodSTE ste = new MethodSTE(p.getNumberOfArguments(), p.getArgumentTypes());
		st.makeBinding(p.getIdentifier(), ste);
	    }
	}
	
	for(Procedure p : methods) {
	    try { p.checkSemantics(st); } 
	    catch (SemanticErrorException se) { se.printSemanticError();  }
	}
	
	main_function.checkSemantics(st);
	return st;
    }
}

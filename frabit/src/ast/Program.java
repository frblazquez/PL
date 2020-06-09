package ast;

import java.util.ArrayList;
import java.util.List;

import asem.MethodSTE;
import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

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
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	for(Procedure p : methods) {
	    if (st.contains(p.getIdentifier()))
		throw new SemanticErrorException("Two methods can not have the same identifier \""+p.getIdentifier()+"\"", p.getLine());
	    else {
		if (p instanceof Function) { // If it's a function we have to keep it's type too
		    Function func = (Function) p;
		    MethodSTE ste = new MethodSTE(func.getNumberOfArguments(), func.getArgumentTypes(), func.getType());
		    st.makeBinding(func.getIdentifier(), ste);
		} else {
		    MethodSTE ste = new MethodSTE(p.getNumberOfArguments(), p.getArgumentTypes());
		    st.makeBinding(p.getIdentifier(), ste);
		}
	    }
	}
	
	for(Procedure p : methods) {
	    try { p.checkSemantics(st); } 
	    catch (SemanticErrorException se) { se.printSemanticError();  }
	}
	
	// As "main" is a reserved word we could delete the following line
	st.makeBinding(new Identifier("main"), new MethodSTE(0, (new ArrayList<Type>())));
	main_function.checkSemantics(st);
    }
    
    @Override
    public CodeLines produceCode() {
    	// TODO: Extend this to function calls
    	CodeLines cls = new CodeLines();
    	cls.add(new CodeLine(PMachineInstructions.SSP, "20")); // TODO: CHANGE 20 FOR ACTUAL SIZE OF LOCAL VARIABLES
    	cls.addAll(main_function.produceCode());
    	cls.add(new CodeLine(PMachineInstructions.STP));
    	return cls;
    }
}

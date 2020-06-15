package ast;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import code.CodeLines;
import errors.GestionErroresTiny;

public class Program extends AstNode {

    private List<Procedure> methods;
    private MainFunction main_function;

    public Program(List<Procedure> methods, MainFunction main) {
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
	    if (st.containsMethod(p.getIdentifier()))
		throw new SemanticErrorException("Two methods can not have the same identifier \""+p.getIdentifier()+"\"", p.getLine());
	    else
		st.addMethod(p);
	}
	
	for(Procedure p : methods) {
	    try { p.checkSemantics(st); } 
	    catch (SemanticErrorException se) { se.printSemanticError();  }
	}
	
	main_function.checkSemantics(st);
    }
    
    @Override
    public void produceCode(CodeLines cls) {
	main_function.produceCode(cls);
	
	for(Procedure m : methods)
	    m.produceCode(cls);

	// Unsolved references should be corrected once the code is generated
	cls.setCallAddresses();
    }

    public void printAST() {
	if (GestionErroresTiny.getSyntacticErrors() > 0)
	    System.out.println("WARN:  AST might be uncompleted because of syntax errors");

	System.out.println(this);
    }

    public void checkSemantics() {
	if (GestionErroresTiny.getSyntacticErrors() > 0) {
	    System.err.println("ERROR: Aborting semantic analysis because syntax errors are present");
	    return;
	}

	try { this.checkSemantics(new SymbolTable()); } 
	catch (SemanticErrorException se) { se.printSemanticError(); }
    }

    public void printPCode() {
	if (GestionErroresTiny.getSyntacticErrors() > 0) {
	    System.err.println("ERROR: Aborting p-code generation because syntax errors are present");
	    return;
	}

	if (GestionErroresTiny.getSemanticErrors() > 0) {
	    System.err.println("ERROR: Aborting p-code generation because semantic errors are present");
	    return;
	}

	CodeLines pcode = new CodeLines();
	this.produceCode(pcode);
	System.out.println(pcode.toString());
    }
}

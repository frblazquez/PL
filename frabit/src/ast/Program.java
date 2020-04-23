package ast;

import java.util.List;

public class Program {

    private List<Procedure> methods;
    private Function main_function;

    public Program(List<Procedure> methods, Function main) {
	this.methods = methods;
	this.main_function = main;
    }
    
    public String toString()
    {
    	String ret = "\\Program\n"; 
    	String tab = "    ";
    	String prefix = "|" + tab;
    	for(Procedure p : methods) 
    	{
    		ret += p.astString(prefix);
    	}
    	ret += main_function.astString(prefix);
    	return ret;
    }
}

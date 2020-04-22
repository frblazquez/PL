package ast;

import java.util.List;

public class Program {

    private List<Procedure> methods;
    private Function main_function;

    public Program(List<Procedure> methods, Function main) {
	this.methods = methods;
	this.main_function = main;
    }
}

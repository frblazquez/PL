package ast.expressions;

import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Constant extends Expression {

    private String constant;

    public Constant(String ct) {
	super(ct);
	constant = ct;
    }

    public Constant(String ct, Type type) {
	super(ct);
	constant = ct;
	expression_type = type;
    }

    @Override
    public String toString() {
	return constant;
    }

    // TODO: What is this for?
    @Override
    public boolean equals(Object o) {

	if (o == this)
	    return true;
	if (!(o instanceof Constant))
	    return false;

	return constant.equals(((Constant) o).constant);
    }

    // We need sets of constants to check switch semantics
    @Override
    public int hashCode() {
	return constant.hashCode();
    }
    
    @Override
    public void produceCode(CodeLines cls) {
    	cls.add(new CodeLine(PMachineInstructions.LDC, constant));
    }

    @Override
    public int stackEvaluationSize() {
	return 1;
    }

}

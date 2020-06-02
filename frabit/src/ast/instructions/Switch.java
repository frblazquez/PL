package ast.instructions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Constant;
import ast.expressions.Expression;
import ast.expressions.OperationTypes;

public class Switch extends Instruction {

    private Expression base_expression;
    private List<Case> cases;
    private Case default_case;

    public Switch(Expression exp, List<Case> cases, Case default_case) {
	super(AstUtils.SWITCH_HEADER);
	this.base_expression = exp;
	this.cases = cases;
	this.default_case = default_case;

	children.add(base_expression);
	children.addAll(cases);
	if (default_case != null)
	    children.add(default_case);
    }

    public Switch(Expression exp, List<Case> cases) {
	this(exp, cases, null);
    }

    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
	// TODO: IMPORTANT!
	// This doesn't work properly, each case also considers as own everything in the
	// scope of the cases before (see sem_errors.txt)
    	super.checkSemantics(st);

    	// Apart from checking semantics of instruction blocks, check cases are not repeated, and that
    	// the expression is of type int
    	if (base_expression.getType(st).getOpType() != OperationTypes.ARITHMETIC)
    	{
    		throw new SemanticErrorException("Switch requires integer expressions", this.line);
    	}
    	Set<Constant> s = new HashSet<>();
    	for (Case cs : cases)
    	{
    		if (s.contains(cs.getConstantExpression()))
    			throw new SemanticErrorException("Repeated case in switch", cs.getLine());
    		else
    			s.add(cs.getConstantExpression());    		
    	}
    	return st;
    }
}

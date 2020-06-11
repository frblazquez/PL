package ast.instructions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Constant;
import ast.expressions.Expression;
import ast.types.IntType;
import code.CodeLines;

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

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	base_expression.checkSemantics(st);
	if (!base_expression.getType().equals(IntType.INT_TYPE))
	    throw new SemanticErrorException("Switch requires an arithmetic base expression", this.line);

	Set<Constant> s = new HashSet<>();
	for(Case c : cases) {
	    if (s.contains(c.getConstantExpression()))
		throw new SemanticErrorException("Repeated case in switch", c.getLine());
	    else
		s.add(c.getConstantExpression());
	}

	for(Case c : cases)
	    c.checkSemantics(st);
	
	this.st = st;
    }
    
    @Override
    public void produceCode(CodeLines cls) {
	base_expression.produceCode(cls);

	// TODO: Fix the jumps!
	for(Case c : cases)
	    c.produceCode(cls);

    }

}

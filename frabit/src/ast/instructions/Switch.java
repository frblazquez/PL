package ast.instructions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.expressions.Constant;
import ast.expressions.Expression;
import ast.types.IntType;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

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

	// Switch would even work with repeated cases
	Set<Constant> s = new HashSet<>();
	for(Case c : cases) {
	    if (s.contains(c.getConstantExpression()))
		throw new SemanticErrorException("Repeated case in switch", c.getLine());
	    else
		s.add(c.getConstantExpression());
	}

	for(Case c : cases)
	    c.checkSemantics(st);
	
	if (default_case != null)
	    default_case.checkSemantics(st);

	this.st = st;
    }
    
    @Override
    public void produceCode(CodeLines cls) {
	base_expression.produceCode(cls);

	List<Integer> jumpsToSwitchEnd = new ArrayList<>();
	for(Case c : cases) {
	    c.produceCode(cls);
	    jumpsToSwitchEnd.add(cls.getNLines() - 1);
	}

	if (default_case != null)
	    default_case.getInstructions().produceCode(cls);

	int switchEnd = cls.getNLines();
	cls.add(new CodeLine(PMachineInstructions.LDC, "0"));
	cls.add(new CodeLine(PMachineInstructions.EQU));
	cls.add(new CodeLine(PMachineInstructions.FJP, "" + (cls.getNLines() + 1)));

	for(int idx : jumpsToSwitchEnd)
	    cls.modifyFirstParam(idx, switchEnd);
    }

}

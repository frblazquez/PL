package ast;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.arguments.ArgumentsDefinition;
import ast.expressions.Expression;
import ast.instructions.Instruction;
import ast.instructions.Instructions;
import ast.instructions.Return;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Function extends Procedure {
    private Return ret;
    private Type ret_type;
    
    public Function(String id, ArgumentsDefinition args, Instructions insts, Type t, Expression e) {
	super(AstUtils.FUNCTION_HEADER, id, args, insts);
	ret = new Return(e);
	ret_type = t;

	children.add(ret_type);
	children.add(ret);
    }
    
    public Type getType() {
	return ret_type;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	SymbolTable func_st = new SymbolTable(st);
	arguments.checkSemantics(func_st);
	
	for(Instruction i : instructions.getInstructions())
	    try{ i.checkSemantics(func_st);}
	    catch(SemanticErrorException e) {e.printSemanticError();}
	
	ret.checkSemantics(func_st);

	if (!ret_type.equals(ret.getReturnType()))
	    throw new SemanticErrorException("Function type and return expression type do not match");
	this.st = func_st;
    }

    @Override
    public void produceCode(CodeLines cls) {
	cls.addMethod(identifier, cls.getNLines());
	cls.add(new CodeLine(PMachineInstructions.SSP, "" + this.staticDataSize()));
	cls.add(new CodeLine(PMachineInstructions.SEP, "" + this.stackEvaluationSize()));
	instructions.produceCode(cls);
	ret.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.RETF));
    }
    
    @Override
    public int stackEvaluationSize() {
	int sesz0, sesz1;
	sesz0 = this.instructions.stackEvaluationSize();
	sesz1 = this.ret.stackEvaluationSize();
	return sesz0 > sesz1 ? sesz0 : sesz1;
    }
    
    @Override
    public int staticDataSize() {
    	// Note that arguments' space will already be considered in instructions' symbol table
    	return this.instructions.staticDataSize();
    }
}

package ast.instructions;

import java.util.ArrayList;
import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstNode;
import ast.AstUtils;

public class Instructions extends AstNode {

    protected List<Instruction> instructions;

    public Instructions() {
	super(AstUtils.INSTRUCTIONS_HEADER);
	instructions = new ArrayList<Instruction>();
    }

    public void add(Instruction instr) {
	instructions.add(instr);
	children.add(instr);
    }

    public List<Instruction> getInstructions() {
	return instructions;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	// Instructions class represents an instruction block so, for checking the
	// semantics we create a new symbol table.
	SymbolTable block_st = new SymbolTable(st);

	for(Instruction i : instructions)
	    try{ i.checkSemantics(block_st);}
	    catch(SemanticErrorException e) {e.printSemanticError();}
    }
}

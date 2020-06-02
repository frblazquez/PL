package ast.instructions;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    @Override
    // TODO: This looks the same than ASTNode.checkSemantics, consider removing it
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	for (Iterator<Instruction> it = instructions.iterator(); it.hasNext(); )
    	{
    		Instruction ins = it.next();
    		if (ins == null) continue; // In case there were syntactic errors
    		try
    		{
    			st = ins.checkSemantics(st); // Definitions update symbol table
    		}
    		catch (SemanticErrorException se)
    		{
    			se.printSemanticError();
    		}
    	}
    	return st;
    }

}

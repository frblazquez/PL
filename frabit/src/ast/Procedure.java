package ast;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.arguments.ArgumentsDefinition;
import ast.instructions.Instructions;
import ast.types.Type;
import code.CodeLine;
import code.CodeLines;
import code.PMachineInstructions;

public class Procedure extends AstNode {

    protected Identifier identifier;
    protected Instructions instructions;
    protected ArgumentsDefinition arguments;

    public Procedure(String id, ArgumentsDefinition args, Instructions insts) {
	this(AstUtils.PROCEDURE_HEADER, id, args, insts);
    }

    /**
     * This constructor allows us to give an own header to function instances
     * (Function extends Procedure).
     */
    public Procedure(String header, String id, ArgumentsDefinition args, Instructions insts) {
	super(header);
	identifier = new Identifier(id);
	instructions = insts;
	arguments = args;

	children.add(identifier);
	children.add(arguments);
	children.add(instructions);
    }
    
    public Identifier getIdentifier()    { return identifier;            }
    public int getNumberOfArguments()    { return arguments.getNumber(); }
    public List<Type> getArgumentTypes() { return arguments.getTypes();  }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	// A procedure defines a new scope with new variables
	SymbolTable proc_st = new SymbolTable(st);
	arguments.checkSemantics(proc_st);
	instructions.checkSemantics(proc_st);
    }

    @Override
    public void produceCode(CodeLines cls) {
	cls.addMethod(identifier, cls.getNLines());
	cls.add(new CodeLine(PMachineInstructions.SSP, "TODO")); // TODO: Static data offset?
	cls.add(new CodeLine(PMachineInstructions.SEP, "TODO")); // TODO: This frame stack space?
	instructions.produceCode(cls);
	cls.add(new CodeLine(PMachineInstructions.RETP));
	cls.add(new CodeLine(PMachineInstructions.DELETEME));
    }
}

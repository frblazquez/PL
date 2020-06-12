package ast.expressions;

import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.AstUtils;
import ast.Function;
import ast.Identifier;
import ast.Procedure;
import ast.arguments.Arguments;
import ast.types.Type;
import code.CodeLines;

/**
 * This class has almost the same schema than Call class, however, this is not
 * an instruction. Only difference is the Type attribute inherited from
 * Expression.
 * 
 */
public class InvokeExpression extends Expression {

    private Identifier identifier;
    private Arguments arguments;

    public InvokeExpression(String id, Arguments args) {
	super(AstUtils.INVOKE_HEADER);
	identifier = new Identifier(id);
	arguments = args;

	children.add(identifier);
	children.add(args);
    }

    @Override
    public String toString() {
	return identifier + "(" + arguments + ")";
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {

	// Might throw SemanticErrorException if not existent
	Procedure p = st.getMethod(identifier);

	// Check the number of arguments
	if (arguments.getNumOfArguments() != p.getNumberOfArguments())
	    throw new SemanticErrorException("Incorrect number of arguments for \"" + identifier + "\"", this.line);

	// Check the type of the arguments
	List<Type> argtypes = p.getTypesOfArguments();
	for(int i = 0; i < argtypes.size(); ++i) {
	    arguments.getArgument(i).checkSemantics(st);
	    if (!argtypes.get(i).equals(arguments.getArgument(i).getType()))
		throw new SemanticErrorException("Argument type mismatch. Expected " + argtypes.get(i) + ", but got "
			+ arguments.getArgument(i).getType() + " instead", this.line);
	}

	if (p instanceof Function) expression_type = ((Function) p).getType();
	else			   expression_type = null;
	this.st = st;
    }
    
    @Override
    public void produceCode(CodeLines cls) {
//	MethodSTE mste = (MethodSTE) this.st.getCertain(identifier);
//	cls.add(new CodeLine(PMachineInstructions.MST, "0"));
//	arguments.produceCode(cls);
//	cls.setUnsolvedReference(cls.getNLines(), identifier);
//	cls.add(new CodeLine(PMachineInstructions.CUP, 
//			Integer.toString(mste.getSizeOfArguments()), Integer.toString(mste.getAddr())));
    }
    
    public int stackEvaluationSize() {
    	return 5 + arguments.stackEvaluationSize(); // Space for MST plus for arguments
    }
}

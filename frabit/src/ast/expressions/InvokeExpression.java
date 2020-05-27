package ast.expressions;

import java.util.List;

import asem.MethodSTE;
import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.AstUtils;
import ast.Identifier;
import ast.arguments.Arguments;
import ast.types.Type;

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
    
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	SymbolTableEntry ste;
    	ste = st.get(identifier);
    	if (! (ste instanceof MethodSTE))
    		throw new SemanticErrorException(identifier + " not a method in this scope",this.line);
    	MethodSTE mste = (MethodSTE) ste;
    	if (arguments.getNumOfArguments() != mste.getNumberOfArguments())
    	{
    		throw new SemanticErrorException("Incorrect number of arguments for " + identifier, this.line);
    	}
    	List<Type> argtypes = mste.getTypesOfArguments();
    	for (int i = 0; i < argtypes.size(); ++i)
    	{
    		// TODO: MAYBE RETHINK EQUALITY OF TYPES
    		// Using an enum as in OperandTypes might do
    		if ( argtypes.get(i).getClass() != arguments.getArgument(i).getType(st).getClass())
    		{
    			throw new SemanticErrorException("Argument type mismatch. Expected "
    					+ argtypes.get(i) + ", but got " 
    					+ arguments.getArgument(i).getType(st) + " instead", this.line); 
    		}
    		// TODO: Rethink which types CAN actually be arguments of a function, especially arrays and pointers issue
    	}
    	return st;
    }
}

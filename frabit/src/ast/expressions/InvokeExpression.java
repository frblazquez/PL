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

    @Override
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException {

	// Might throw SemanticErrorException if not existent
	SymbolTableEntry ste = st.get(identifier);

	if (!(ste instanceof MethodSTE))
	    throw new SemanticErrorException("\"" + identifier + "\" is not a method in this scope", this.line);

	MethodSTE mste = (MethodSTE) ste;
	if (arguments.getNumOfArguments() != mste.getNumberOfArguments())
	    throw new SemanticErrorException("Incorrect number of arguments for " + identifier, this.line);

	List<Type> argtypes = mste.getTypesOfArguments();
	for(int i = 0; i < argtypes.size(); ++i) {
	    arguments.getArgument(i).checkSemantics(st);
	    if (argtypes.get(i).equals(arguments.getArgument(i).getType())) {
		throw new SemanticErrorException("Argument type mismatch. Expected " + argtypes.get(i) + ", but got "
			+ arguments.getArgument(i).getType() + " instead", this.line);
	    }
	}

	expression_type = ste.getType();

	return st;
    }
}

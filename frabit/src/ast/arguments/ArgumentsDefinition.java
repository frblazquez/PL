package ast.arguments;

import java.util.ArrayList;
import java.util.List;

import asem.SemanticErrorException;
import asem.SymbolTable;
import asem.SymbolTableEntry;
import ast.AstNode;
import ast.AstUtils;
import ast.types.Type;

public class ArgumentsDefinition extends AstNode {

    private List<PairArgumentType> arguments;

    public ArgumentsDefinition() {
	super(AstUtils.PARAMS_DEF_HEADER);
	arguments = new ArrayList<PairArgumentType>();
    }

    public ArgumentsDefinition(List<PairArgumentType> args) {
	super(AstUtils.PARAMS_DEF_HEADER);
	arguments = args;
	children.addAll(args);
    }

    public int getNumber() {
	return arguments.size();
    }

    public List<Type> getTypes() {
	List<Type> list = new ArrayList<Type>();
	for(PairArgumentType at : arguments) {
	    list.add(at.getType());
	}
	return list;
    }

    @Override
    public void checkSemantics(SymbolTable st) throws SemanticErrorException {
	for(PairArgumentType at : arguments) {
	    if (st.contains(at.getIdentifier()))
		throw new SemanticErrorException("Argument identifier \"" + at.getIdentifier() + "\" is being used", this.line);

	    st.makeBinding(at.getIdentifier(), new SymbolTableEntry(at.getType()));
	}
	this.st = st;
    }
}

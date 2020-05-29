package ast.expressions;

import asem.SemanticErrorException;
import asem.SymbolTable;
import ast.types.Type;

public class BinaryExpression extends Expression{

    private Operators op;
    private Expression left_e;
    private Expression right_e;

    public BinaryExpression(Operators op, Expression left_e, Expression right_e) {
	super(op.toString());
    this.op = op;
	this.left_e = left_e;
	this.right_e = right_e;
	this.children.add(left_e);
	this.children.add(right_e);
    }
    
    @Override
    public String toString() {
	return left_e + " " + op + " " + right_e;
    }
    
    public Type getType(SymbolTable st) throws SemanticErrorException
    {
    	return left_e.getType(st);
    }
    
    public SymbolTable checkSemantics(SymbolTable st) throws SemanticErrorException
    {
    	left_e.checkSemantics(st);
    	right_e.checkSemantics(st);
    	
    	OperationTypes optype = left_e.getType(st).getOpType();
    	
    	if (optype != right_e.getType(st).getOpType() || optype != op.operandType()) 
    		throw new SemanticErrorException("Operand types do not match in expression");
    	
    	// TODO: Consider this more verbose output, would require implementing further toString methods
//    	if (optype != right_e.getType(st).getOpType() || optype != op.operandType()) 
//    		throw new SemanticErrorException("Operand types do not match in expression: " + this.toString());

    	return st;
    }

}

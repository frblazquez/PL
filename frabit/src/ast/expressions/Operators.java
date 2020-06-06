//@formatter:off
package ast.expressions;

import ast.types.BoolType;
import ast.types.IntType;
import ast.types.Type;

public enum Operators {

    MAYOR, MAYORIGUAL, MENOR, MENORIGUAL, IGUALIGUAL, DISTINTO, MAS, MENOS, POR, DIVISION, AND, OR, NOT, AMPERSAND;

    @Override
    public String toString() {
	switch(this) {
        	case AMPERSAND:	 return "&";
        	case AND:	 return "and"; 
        	case DISTINTO:   return "!=";
        	case DIVISION:   return "/";
        	case IGUALIGUAL: return "==";
        	case MAS:	 return "+";
        	case MAYOR: 	 return ">"; 
        	case MAYORIGUAL: return ">=";
        	case MENOR:	 return "<";
        	case MENORIGUAL: return "<=";
        	case MENOS:	 return "-";
        	case NOT:	 return "not";
        	case OR:	 return "or";
        	case POR:	 return "*";
        	default:	 throw new RuntimeException("Unknown operator!");
	}
    }
    
    // TODO: IMPORTANT!
    // Pointers are temporally excluded
    
    public Type operandType(){
    	switch(this) {
	    	case POR:	 	return IntType.INT_TYPE; 
	    	case DISTINTO:   	return IntType.INT_TYPE;
	    	case DIVISION:   	return IntType.INT_TYPE;
	    	case IGUALIGUAL: 	return IntType.INT_TYPE;
	    	case MAS:	 	return IntType.INT_TYPE;
	    	case MAYOR: 	 	return IntType.INT_TYPE; 
	    	case MAYORIGUAL: 	return IntType.INT_TYPE;
	    	case MENOR:	 	return IntType.INT_TYPE;
	    	case MENORIGUAL: 	return IntType.INT_TYPE;
	    	case MENOS:	 	return IntType.INT_TYPE;
	    	case AND:	 	return BoolType.BOOL_TYPE;
	    	case NOT:	 	return BoolType.BOOL_TYPE;
	    	case OR:	 	return BoolType.BOOL_TYPE;
	    	//case AMPERSAND:	return OperationTypes.ARITHMETIC;
	    	default:	 	throw new RuntimeException("Unknown operator!");
    	}
    }
    
    public Type resultType(){
    	switch(this) {
    		case DIVISION:   	return IntType.INT_TYPE;
    		case MAS:	 	return IntType.INT_TYPE;
    		case MENOS:	 	return IntType.INT_TYPE;
    		case POR:	 	return IntType.INT_TYPE; 
	    	case AND:	 	return BoolType.BOOL_TYPE;
	    	case DISTINTO:   	return BoolType.BOOL_TYPE;
	    	case IGUALIGUAL: 	return BoolType.BOOL_TYPE;
	    	case MAYOR: 	 	return BoolType.BOOL_TYPE; 
	    	case MAYORIGUAL: 	return BoolType.BOOL_TYPE;
	    	case MENOR:	 	return BoolType.BOOL_TYPE;
	    	case MENORIGUAL: 	return BoolType.BOOL_TYPE;
	    	case NOT:	 	return BoolType.BOOL_TYPE;
	    	case OR:	 	return BoolType.BOOL_TYPE;
	    	//case AMPERSAND:	return OperationTypes.ARITHMETIC;
	    	default:	 	throw new RuntimeException("Unknown operator!");
    	}
    }
    
    public int getArity(){
    	switch(this) {
	    	case NOT:	 	return 1;
	    	//case AMPERSAND:	return 1;
	    	default:	 	return 2;
    	}
    }
}

//@formatter:off
package ast.expressions;

import ast.types.BoolType;
import ast.types.IntType;
import ast.types.PointerType;
import ast.types.Type;
import code.PMachineInstructions;

public enum Operators {

    MAYOR, MAYORIGUAL, MENOR, MENORIGUAL, 
    IGUALIGUAL, DISTINTO, MAS, MENOS, POR, 
    DIVISION, AND, OR, NOT, AMPERSAND, DEREF;

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
        	case DEREF:	 return "*";	
        	default:	 throw new RuntimeException("Unknown operator!");
	}
    }
    
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
	    	case AMPERSAND:		return new PointerType(); // Unused
	    	case DEREF:		return IntType.INT_TYPE;
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
	    	case AMPERSAND:		return new PointerType(); // Unused
	    	case DEREF:		return new PointerType(); // Unused
	    	default:	 	throw new RuntimeException("Unknown operator!");
    	}
    }
    
    public PMachineInstructions opInstruction(){
    	switch(this) {
    		case DIVISION:   	return PMachineInstructions.DIV;
    		case MAS:	 		return PMachineInstructions.ADD;
    		case MENOS:	 		return PMachineInstructions.SUB;
    		case POR:	 		return PMachineInstructions.MUL; 
	    	case AND:	 		return PMachineInstructions.AND;
	    	case OR:	 		return PMachineInstructions.OR;
	    	case NOT:	 		return PMachineInstructions.NOT;
	    	case DISTINTO:   	return PMachineInstructions.NEQ;
	    	case IGUALIGUAL: 	return PMachineInstructions.EQU;
	    	case MAYOR: 	 	return PMachineInstructions.GRT; 
	    	case MAYORIGUAL: 	return PMachineInstructions.GEQ;
	    	case MENOR:	 		return PMachineInstructions.LES;
	    	case MENORIGUAL: 	return PMachineInstructions.LEQ;
	    	//case AMPERSAND:	return OperationTypes.ARITHMETIC;
	    	default:	 	throw new RuntimeException("Unknown operator!");
    	}
    }
    
    public int getArity(){
    	switch(this) {
	    	case NOT:	 	return 1;
	    	case MENOS: 		return 2;
	    	case AMPERSAND:	return 1;
	    	case DEREF:		return 1;
	    	default:	 	return 2;
    	}
    }
}

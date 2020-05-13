package ast.expressions;

public enum Operators {

    MAYOR, MAYORIGUAL, MENOR, MENORIGUAL, IGUALIGUAL, DISTINTO, MAS, MENOS, POR, DIVISION, AND, OR, NOT, AMPERSAND;

    @Override
    public String toString() {
	//@formatter:off
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
    
    // TODO: Pointer access and dereferencing needs to be checked
    
    public OperationTypes operandType()
    {
    	switch(this) 
    	{
	    	case AMPERSAND:	 	return OperationTypes.ARITHMETIC; // TODO: This needs changing
	    	case AND:	 		return OperationTypes.BOOLEAN;
	    	case DISTINTO:   	return OperationTypes.ARITHMETIC;
	    	case DIVISION:   	return OperationTypes.ARITHMETIC;
	    	case IGUALIGUAL: 	return OperationTypes.ARITHMETIC;
	    	case MAS:	 		return OperationTypes.ARITHMETIC;
	    	case MAYOR: 	 	return OperationTypes.ARITHMETIC; 
	    	case MAYORIGUAL: 	return OperationTypes.ARITHMETIC;
	    	case MENOR:	 		return OperationTypes.ARITHMETIC;
	    	case MENORIGUAL: 	return OperationTypes.ARITHMETIC;
	    	case MENOS:	 		return OperationTypes.ARITHMETIC;
	    	case NOT:	 		return OperationTypes.BOOLEAN;
	    	case OR:	 		return OperationTypes.BOOLEAN;
	    	case POR:	 		return OperationTypes.ARITHMETIC; // TODO: Pointer access
	    	default:	 		throw new RuntimeException("Unknown operator!");
    	}
    }
    
    public OperationTypes resultType()
    {
    	switch(this) 
    	{
	    	case AMPERSAND:	 	return OperationTypes.ARITHMETIC; // Returns a number, memory address
	    	case AND:	 		return OperationTypes.BOOLEAN;
	    	case DISTINTO:   	return OperationTypes.BOOLEAN;
	    	case DIVISION:   	return OperationTypes.ARITHMETIC;
	    	case IGUALIGUAL: 	return OperationTypes.BOOLEAN;
	    	case MAS:	 		return OperationTypes.ARITHMETIC;
	    	case MAYOR: 	 	return OperationTypes.BOOLEAN; 
	    	case MAYORIGUAL: 	return OperationTypes.BOOLEAN;
	    	case MENOR:	 		return OperationTypes.BOOLEAN;
	    	case MENORIGUAL: 	return OperationTypes.BOOLEAN;
	    	case MENOS:	 		return OperationTypes.ARITHMETIC;
	    	case NOT:	 		return OperationTypes.BOOLEAN;
	    	case OR:	 		return OperationTypes.BOOLEAN;
	    	case POR:	 		return OperationTypes.ARITHMETIC; // TODO: Pointer access
	    	default:	 		throw new RuntimeException("Unknown operator!");
    	}
    }
}

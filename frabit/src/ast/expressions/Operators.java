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
}

package ast.expressions;

public enum Operation {
	EQUAL("==", TypeOfExpression.INT), DIFFERENT("!=", TypeOfExpression.INT), LT("<", TypeOfExpression.INT), 
	GT(">", TypeOfExpression.INT), LEQ("<=", TypeOfExpression.INT), GEQ(">=", TypeOfExpression.INT), 
	SUM("+", TypeOfExpression.INT), SUB("-", TypeOfExpression.INT), 
	OR("or", TypeOfExpression.INT), MUL("*", TypeOfExpression.INT), 
	DIV("/", TypeOfExpression.INT), AND("and", TypeOfExpression.BOOL), 
	OPPOSITE("-", TypeOfExpression.INT), NOT("not", TypeOfExpression.BOOL), AMPERSAND("&", TypeOfExpression.INT);
	
	private String op_str;
	private TypeOfExpression type_expr;
	
	private Operation(String op, TypeOfExpression type)
	{
		op_str = op;
		type_expr = type;
	}
	
	public String getStr()
	{
		return op_str;
	}
	
	public TypeOfExpression getType()
	{
		return type_expr;
	}
	
//	public TypeOfExpression getType()
//	{
//		switch (this)
//		{
//		case EQUAL : 	return TypeOfExpression.INT;
//		case DIFFERENT: return TypeOfExpression.INT;
//		case LT:		return TypeOfExpression.BOOL;
//		case GT:		return TypeOfExpression.BOOL;
//		case LEQ:		return TypeOfExpression.BOOL;
//		case GEQ:		return TypeOfExpression.BOOL;
//		case SUM:		return TypeOfExpression.INT;
//		case SUB:		return TypeOfExpression.INT;
//		case OR:		return TypeOfExpression.BOOL;
//		case MUL:		return TypeOfExpression.INT;
//		case DIV:		return TypeOfExpression.INT;
//		case AND:		return TypeOfExpression.BOOL;
//		case OPPOSITE: 	return TypeOfExpression.INT;
//		case NOT:		return TypeOfExpression.BOOL;
//		case AMPERSAND:	return TypeOfExpression.INT;
//		default: return null;
//		}
//	}
	
	public static Operation strToOp(String s)
	{
		if (s.equals("==")) 		return EQUAL; 
		else if (s.equals("!=")) 	return DIFFERENT;
		else if (s.equals("<")) 	return LT;
		else if (s.equals(">")) 	return GT;
		else if (s.equals("<=")) 	return LEQ;
		else if (s.equals(">=")) 	return GEQ;
		else if (s.equals("+")) 	return SUM;
		else if (s.equals("-")) 	return SUB;
		else if (s.equals("or")) 	return OR;
		else if (s.equals("*")) 	return MUL;
		else if (s.equals("/")) 	return DIV;
		else if (s.equals("and"))	return AND;
		else if (s.equals("-")) 	return OPPOSITE;
		else if (s.equals("not")) 	return NOT;
		else if (s.equals("&")) 	return AMPERSAND;
		else 						return null;
	}
}

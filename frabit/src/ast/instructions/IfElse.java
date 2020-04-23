package ast.instructions;


import ast.Expression;

public class IfElse extends Instruction {

    private Expression condition;
    private Instructions if_instructions;
    private Instructions else_instructions;

    public IfElse(Expression e, Instructions if_ins) {
	condition = e;
	if_instructions = if_ins;
	else_instructions = null;
    }

    public IfElse(Expression e, Instructions if_ins, Instructions else_ins) {
	condition = e;
	if_instructions = if_ins;
	else_instructions = else_ins;
    }

    public boolean hasElseClause() {
	return else_instructions != null;
    }
    
    public String astString(String prefix)
    {
    	String ret = prefix.substring(0,prefix.length()-1) + "\\__if\n";
    	
    	ret += condition.astString(prefix + "    |");
    	ret += if_instructions.astString(prefix);
    	if (this.hasElseClause()) ret += else_instructions.astString(prefix);
//    	ret += condition.astString(prefix + "    ");
//    	if (this.hasElseClause())
//    	{
//    		ret += if_instructions.astString(prefix + "    ");
//    		ret += prefix + "    \\__else\n";
//    		ret += else_instructions.astString(prefix + "    ");
//    	}
//    	else ret += if_instructions.astString(prefix);
    	return ret;
    }
}

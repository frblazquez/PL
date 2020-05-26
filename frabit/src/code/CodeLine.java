package code;

public class CodeLine {
private int line_number;
private int parameter1;
private int parameter2;
private boolean has_jump;
private JumpDecided jd;
private PMachineInstructions instruction;

public CodeLine()
{
	line_number = -1;
	parameter1 = parameter2 = -1;
	has_jump = false;
	jd = JumpDecided.NOT_DECIDED;
}

public String toString()
{
	StringBuilder sb = new StringBuilder("");
	sb.append(instruction.toString());
	if (parameter1 >= 0)
	{
		sb.append(" ");
		sb.append(parameter1);
		if (parameter2 >= 0)
		{
			sb.append(" ");
			sb.append(parameter2);
		}
		sb.append("\n");
	}
	return sb.toString(); 
}

public enum JumpDecided
{
	NOT_DECIDED, DECIDED;
}

}

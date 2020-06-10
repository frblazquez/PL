package code;

public class CodeLine {
private int line_number;
private String parameter1; // Parameters are either integers or true/false constants
private String parameter2;
private int num_parameters;
private boolean has_jump;
private JumpDecided jd;
private PMachineInstructions instruction;

public CodeLine()
{
	line_number = -1;
	has_jump = false;
	jd = JumpDecided.NOT_DECIDED;
}

public CodeLine(PMachineInstructions instruction)
{
	line_number = -1;
	has_jump = false;
	jd = JumpDecided.NOT_DECIDED;
	this.instruction = instruction;
}

public CodeLine(PMachineInstructions instruction, String parameter1)
{
	line_number = -1;
	num_parameters = 1;
	this.parameter1 = parameter1;
	this.instruction = instruction;
}

public CodeLine(PMachineInstructions instruction, String parameter1, String parameter2)
{
	line_number = -1;
	this.parameter1 = parameter1;
	this.parameter2 = parameter2;
	num_parameters = 1;
	this.instruction = instruction;
}

public enum JumpDecided
{
	NOT_DECIDED, DECIDED;
}

public int getLine() { return line_number; }
public PMachineInstructions getInstruction() { return instruction; }

public void setFirstParameter(String parameter1)  { // TODO: Think of improving this 
	this.parameter1 = parameter1; 
	if (num_parameters < 1)
		num_parameters = 1;	
}
public void setSecondParameter(String parameter2) {
	this.parameter2 = parameter2;
	num_parameters = 2;
}

public String toString() {
	StringBuilder sb = new StringBuilder("");
	sb.append('{');
	sb.append(this.line_number);
	sb.append('}');
	sb.append(' ');
	sb.append(instruction.toString());
	if (num_parameters > 0) {
		sb.append(' ');
		sb.append(parameter1);
		if (num_parameters == 2) { // Num of parameters can only be 0, 1 or 2
			sb.append(' ');
			sb.append(parameter2);
		}
	}
	sb.append(';');
	return sb.toString();
}
}

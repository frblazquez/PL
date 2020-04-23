package ast.instructions;

public class Instruction {

	public String astString(String prefix) {
		return prefix.substring(0,prefix.length()-1) + "\\__instruccion\n";
	}

}

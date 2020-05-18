package asem;

import java.util.List;

import ast.types.Type;

public class MethodSTE extends SymbolTableEntry 
{
	private int number_of_arguments;
	private List<Type> types_of_arguments;
	
	public MethodSTE() {}
	
	public void setNumberOfArguments(int number_of_arguments)
	{
		this.number_of_arguments = number_of_arguments;
	}
	
	public void setTypesOfArguments(List<Type> types_of_arguments)
	{
		this.types_of_arguments = types_of_arguments;
	}
	
	public int getNumberOfArguments() 			{ return this.number_of_arguments; }
	public List<Type> getTypesOfArguments() { return this.types_of_arguments; }
	
}

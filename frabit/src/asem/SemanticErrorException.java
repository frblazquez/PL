package asem;

public class SemanticErrorException extends Exception { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SemanticErrorException(String errorMessage) {
        super(errorMessage);
    }
	
	public void printSemanticError()
	{
		System.out.println("Semantic error: " + this.getMessage());
	}
}

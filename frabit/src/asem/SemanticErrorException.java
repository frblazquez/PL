package asem;

public class SemanticErrorException extends Exception { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line;
	
	public SemanticErrorException(String errorMessage) {
        super(errorMessage);
    }
	
	public SemanticErrorException(String errorMessage, int line) {
        super(errorMessage);
        this.line = line;
    }
	
	public void printSemanticError()
	{
		System.out.println("Semantic error: " + this.getMessage());
	}
}

package asem;

public class SemanticErrorException extends Exception {

    private static final long serialVersionUID = 1L;
    private int line;

    public SemanticErrorException(String errorMessage) {
	super(errorMessage);
	line = -1;
    }

    public SemanticErrorException(String errorMessage, int line) {
	super(errorMessage);
	this.line = line;
    }

    public void setLine(int line) {
	this.line = line;
    }

    public void printSemanticError() {
	System.out.println("Semantic error on line " + line + ": " + this.getMessage());
    }
}

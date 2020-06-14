package errors;

import alex.TokenValue;
import alex.UnidadLexica;

public class GestionErroresTiny {
 
    private static int lexical_errors  = 0;
    private static int syntax_errors   = 0;
    private static int semantic_errors = 0;
    
    public static void errorLexico(int fila, String lexema) {
	System.out.println("Lexical error in line " + fila + ": Unexpected character: \"" + lexema + "\"");
	lexical_errors++;

	System.err.println("ERROR: Compilation process aborted because lexical errors are present");
	System.exit(1);
    }

    public static void errorSintactico(UnidadLexica unidadLexica) {
	System.out.print("Syntax error on line " + ((TokenValue) unidadLexica.value).line + ": Unexpected token \""+ unidadLexica.lexema() + "\" ");
	syntax_errors++;
	// System.exit(1);
    }

    public static void errorSemantico(String msg, int line) {
	System.out.println("Semantic error on line " + line + ": " + msg);
	semantic_errors++;
	// System.exit(1);
    }
    
    public static int getLexicalErrors()   { return lexical_errors; }
    public static int getSyntacticErrors() { return syntax_errors; }
    public static int getSemanticErrors()  { return semantic_errors; }
}

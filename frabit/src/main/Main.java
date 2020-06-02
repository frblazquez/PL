package main;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import asem.SymbolTable;
import asint.AnalizadorSintacticoTiny;
import ast.Program;

public class Main {

    //@formatter:off
    public static final String BASE_FOLDER 		 = "test-files/";
    public static final String AST_DISPLAY_FOLDER        = BASE_FOLDER+"ast/";
    public static final String ERROR_RECOVERY_FOLDER     = BASE_FOLDER+"error-recovery/";
    public static final String SEMANTIC_ANALYSIS_FOLDER  = BASE_FOLDER+"sem-analysis/";
    public static final String TEST_ALL 		 = BASE_FOLDER+"input.txt";
    
    public static final String TEST_INSTRUCTIONS_DISPLAY = "instructions_ast.txt";
    public static final String TEST_ACCESSES_DISPLAY 	 = "accesses_ast.txt";
    public static final String TEST_EXPRESSIONS_DISPLAY  = "expressions_ast.txt";
    public static final String TEST_TYPES_DISPLAY 	 = "types_ast.txt";
    public static final String TEST_ERROR_RECOVERY  	 = "error_recovery.txt";
    public static final String TEST_TYPE_ERROR_RECOVERY  = "types_er.txt";
    public static final String TEST_EXP_ERROR_RECOVERY   = "expressions_er.txt";
    public static final String TEST_INST_ERROR_RECOVERY  = "instructions_er.txt";
    public static final String TEST_COMMON_ERROR_RECOVERY= "common_er.txt";
    public static final String TEST_SEMANTIC_ERRORS 	 = "sem_errors.txt";
    //@formatter:on

    public static void main(String[] args) throws Exception {
	String input_file = SEMANTIC_ANALYSIS_FOLDER + TEST_SEMANTIC_ERRORS;
	
	Reader input = new InputStreamReader(new FileInputStream(input_file));
	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);

	Program pr = (Program) asint.parse().value;
	pr.checkSemantics(new SymbolTable());
	// System.out.println(pr);
    }
}

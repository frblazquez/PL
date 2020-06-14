package main;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import asint.AnalizadorSintacticoTiny;
import ast.Program;

public class Main {

    //@formatter:off
    public static final String BASE_FOLDER 		 = "test-files/";
    public static final String AST_DISPLAY_FOLDER        = BASE_FOLDER+"ast/";
    public static final String ERROR_RECOVERY_FOLDER     = BASE_FOLDER+"error-recovery/";
    public static final String SEMANTIC_ANALYSIS_FOLDER  = BASE_FOLDER+"sem-analysis/";
    public static final String CODE_GENERATION_FOLDER    = BASE_FOLDER+"code-gen/";
    public static final String TEST_ALL 		 = BASE_FOLDER+"input.txt";
    
    // AST construction and display test files
    public static final String TEST_INSTRUCTIONS_DISPLAY = "instructions_ast.txt";
    public static final String TEST_ACCESSES_DISPLAY 	 = "accesses_ast.txt";
    public static final String TEST_EXPRESSIONS_DISPLAY  = "expressions_ast.txt";
    public static final String TEST_TYPES_DISPLAY 	 = "types_ast.txt";
    
    // Error recovery test files
    public static final String TEST_ERROR_RECOVERY  	 = "error_recovery.txt";
    public static final String TEST_TYPE_ERROR_RECOVERY  = "types_er.txt";
    public static final String TEST_EXP_ERROR_RECOVERY   = "expressions_er.txt";
    public static final String TEST_INST_ERROR_RECOVERY  = "instructions_er.txt";
    public static final String TEST_COMMON_ERROR_RECOVERY= "common_er.txt";
    
    // Semantic analysis tests files
    public static final String TEST_SEMANTIC_ANALYSIS 	    = "sem_errors.txt";
    public static final String TEST_EXP_SEMANTIC_ANALYSIS   = "expressions_sa.txt";
    public static final String TEST_TYPE_SEMANTIC_ANALYSIS  = "types_sa.txt";
    public static final String TEST_INST_SEMANTIC_ANALYSIS  = "instructions_sa.txt";
    public static final String TEST_COMMON_SEMANTIC_ANALYSIS= "common_sa.txt";
    //@formatter:on

    public static void main(String[] args) throws Exception {
	String input_file;
	if (args.length > 0)
		input_file = args[0];
	else 
		input_file = CODE_GENERATION_FOLDER + "concrete_testing.txt";
	
	Reader input = new InputStreamReader(new FileInputStream(input_file));
	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);

	Program pr = (Program) asint.parseInput();
	// pr.printAST();
	pr.checkSemantics();
	pr.printPCode();
    }

    // TODO: REMAINING
    // -> Error recovery improvement
    // -> Semantic analysis review
    // -> Set lines properly (not -1 anymore)
    // -> P-code generation review
}

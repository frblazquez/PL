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
    public static final String TEST_ALL 		 = "input.txt";
    public static final String TEST_INSTRUCTIONS_DISPLAY = "instructions.txt";
    public static final String TEST_ACCESSES_DISPLAY 	 = "accesses.txt";
    public static final String TEST_EXPRESSIONS_DISPLAY  = "expressions.txt";
    public static final String TEST_TYPES_DISPLAY 	 = "types.txt";
    public static final String TEST_ERROR_RECOVERY = "error_recovery.txt";
    //@formatter:on

    public static void main(String[] args) throws Exception {
	String input_file = BASE_FOLDER + TEST_ERROR_RECOVERY;
	
	Reader input = new InputStreamReader(new FileInputStream(input_file));
	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	try
	{
		Program pr = (Program) asint.parse().value;
		System.out.println(pr);
	}
	catch (Exception e)
	{
		System.out.println("Could not recover");
	}
    }
}

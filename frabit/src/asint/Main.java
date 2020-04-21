package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Programa;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
	 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	 AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	 //asint.setScanner(alex);
	 //asint.parse();
	 Programa pr = (Programa) asint.parse().value;
	 System.out.println(pr);
	 //System.out.println(((Programa) asint.parse().value));
 }
}   
   

package main;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import asint.AnalizadorSintacticoTiny;
import ast.Program;

public class Main {
    public static void main(String[] args) throws Exception {
	Reader input = new InputStreamReader(new FileInputStream("input.txt"));
	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	Program pr = (Program) asint.parse().value;
	System.out.println(pr);
    }
}

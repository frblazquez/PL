package errors;

import alex.TokenValue;
import alex.UnidadLexica;

public class GestionErroresTiny {
   public void errorLexico(int fila, String lexema) {
     System.out.println("Lexical error in line " + fila + ": Unexpected character: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.print("Syntax error in line "+ ((TokenValue) unidadLexica.value).line +": Unexpected token "+unidadLexica.lexema() + " ");
     //System.exit(1);
   }
}

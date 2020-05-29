package errors;

import alex.UnidadLexica;

public class GestionErroresTiny {
   public void errorLexico(int fila, String lexema) {
     System.out.println("Lexical error in line " + fila + ": Unexpected character: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.print("Syntax error in line "+unidadLexica.fila()+": Unexpected token "+unidadLexica.value + " ");
     //System.exit(1);
   }
}

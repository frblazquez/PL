package errors;

import java_cup.runtime.Symbol;

public class GestionErroresTiny {
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR fila "+fila+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  

    public void errorSintactico(Symbol unidadLexica) {
	System.out.print("ERROR fila : Elemento inexperado " + unidadLexica.value);
     System.exit(1);
   }
}

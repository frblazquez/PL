package errors;

import alex.UnidadLexica;

public class GestionErroresTiny {
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR léxico fila "+fila+": Carácter inesperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.print("ERROR sintáctico fila "+unidadLexica.fila()+": Elemento inesperado "+unidadLexica.value);
     System.exit(1);
   }
}

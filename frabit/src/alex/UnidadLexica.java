package alex;

import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
   public UnidadLexica(int fila, int clase, String lexema) {
     super(clase,new TokenValue(lexema,fila));
   }
   public int clase () {return sym;}
   public String lexema() {return ((TokenValue)value).token;}
}

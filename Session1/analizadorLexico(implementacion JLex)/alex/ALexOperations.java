package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.IDEN,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadEvalua() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.EVALUA); 
  } 
  public UnidadLexica unidadDonde() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DONDE); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadReal() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.REAL,alex.lexema()); 
  }
  public UnidadLexica unidadBinario() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.BINARIO,alex.lexema()); 
  }
  public UnidadLexica unidadHexadecimal() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.HEXADECIMAL,alex.lexema()); 
  }   
  public UnidadLexica unidadPalabra() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.PALABRA,alex.lexema()); 
  }  
  public UnidadLexica unidadPatron() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.PATRON,alex.lexema()); 
  }   
  public UnidadLexica unidadOtro() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.OTRO,alex.lexema()); 
  }   
  public UnidadLexica unidadSuma() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.POR); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DIV); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PCIERRE); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IGUAL); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.COMA); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.EOF); 
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}

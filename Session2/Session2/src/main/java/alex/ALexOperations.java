package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IDEN,alex.lexema()); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAS,"+"); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MENOS,"-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(),ClaseLexica.POR,"*"); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DIV,"/"); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PAP,"("); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.PCIERRE,")"); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),ClaseLexica.IGUAL,"="); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(),ClaseLexica.COMA,","); 
  } 
  public UnidadLexica unidadAlmohadilla() {
     return new UnidadLexica(alex.fila(),ClaseLexica.ALMOHADILLA,"#"); 
  } 
  public UnidadLexica unidadMayor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MAYOR,">"); 
  } 
  public UnidadLexica unidadMenor() {
     return new UnidadLexica(alex.fila(),ClaseLexica.MENOR,"<"); 
  } 
  public UnidadLexica unidadCAp() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CAP,"["); 
  } 
  public UnidadLexica unidadCCierre() {
     return new UnidadLexica(alex.fila(),ClaseLexica.CCIERRE,"]"); 
  } 
  public UnidadLexica unidadDistinto() {
     return new UnidadLexica(alex.fila(),ClaseLexica.DISTINTO,"!="); 
  } 
  public UnidadLexica unidadIgualIgual() {
	     return new UnidadLexica(alex.fila(),ClaseLexica.IGUALIGUAL,"=="); 
	  }
  public UnidadLexica unidadLMap() {
	  return new UnidadLexica(alex.fila(),ClaseLexica.LMAP,"lmap");
  }
  public UnidadLexica unidadLReduce() {
	  return new UnidadLexica(alex.fila(),ClaseLexica.LREDUCE,"lreduce");
  }
  public UnidadLexica unidadLFilter() {
	  return new UnidadLexica(alex.fila(),ClaseLexica.LFILTER,"lfilter");
  }
  public UnidadLexica unidadPrint() {
	  return new UnidadLexica(alex.fila(),ClaseLexica.PRINT,"print");
  }
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF,"<EOF>"); 
  }
}

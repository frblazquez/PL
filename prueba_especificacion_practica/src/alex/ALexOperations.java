package alex;

import asint.ClaseLexica;
import java_cup.runtime.Symbol;

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
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),ClaseLexica.EOF,"<EOF>"); 
  }
public UnidadLexica unidadPuntoComa() {
	return new UnidadLexica(alex.fila(), ClaseLexica.PUNTOCOMA, ";");
}
public UnidadLexica unidadLAp() {
	return new UnidadLexica(alex.fila(), ClaseLexica.LLAP, "{");
}
public UnidadLexica unidadLCierre() {
	return new UnidadLexica(alex.fila(), ClaseLexica.LLCIERRE, "}");
}
public UnidadLexica unidadOr() {
	return new UnidadLexica(alex.fila(), ClaseLexica.OR, "or");
}
public UnidadLexica unidadIf() {
	return new UnidadLexica(alex.fila(), ClaseLexica.IF, "if");
}
public UnidadLexica unidadIgualIgual() {
	return new UnidadLexica(alex.fila(), ClaseLexica.IGUALIGUAL, "==");
}
public UnidadLexica unidadMayorIgual() {
	return new UnidadLexica(alex.fila(), ClaseLexica.MAYORIGUAL, ">=");
}
public UnidadLexica unidadMenorIgual() {
	return new UnidadLexica(alex.fila(), ClaseLexica.MENORIGUAL, "<=");
}
public UnidadLexica unidadAnd() {
	return new UnidadLexica(alex.fila(), ClaseLexica.AND, "and");
}
public UnidadLexica unidadNot() {
	return new UnidadLexica(alex.fila(), ClaseLexica.NOT, "not");
}
public UnidadLexica unidadInt() {
	return new UnidadLexica(alex.fila(), ClaseLexica.INT, "int");
}
public UnidadLexica unidadTrue() {
	return new UnidadLexica(alex.fila(), ClaseLexica.TRUE, "true");
}
public UnidadLexica unidadElse() {
	return new UnidadLexica(alex.fila(), ClaseLexica.ELSE, "else");
}
public UnidadLexica unidadBool() {
	return new UnidadLexica(alex.fila(), ClaseLexica.BOOL, "bool");
}
public UnidadLexica unidadWhile() {
	return new UnidadLexica(alex.fila(), ClaseLexica.WHILE, "while");
}
public UnidadLexica unidadFalse() {
	return new UnidadLexica(alex.fila(), ClaseLexica.FALSE, "false");
}
public UnidadLexica unidadReturn() {
	return new UnidadLexica(alex.fila(), ClaseLexica.RETURN, "return");
}
}

package alex;
import asint.sym;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%

%public
%class Lexer
%cup
%implements sym
%char
%line

%{
    StringBuffer string = new StringBuffer();
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,0,(int)yychar), new Location(yyline+1,0+yylength(),(int)yychar+yylength()));
  }
  
  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline+1,0,(int)yychar);
      Location right= new Location(yyline+1,0+yylength(),(int) yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  } 
  private Symbol symbol(String name, int sym, Object val,int buflength) {
      Location left = new Location(yyline+1,0+yylength()-buflength,(int)yychar+yylength()-buflength);
      Location right= new Location(yyline+1,0+yylength(), (int) yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  }       
  private void error(String message) {
    System.out.println("Error at line "+(yyline+1)+", column "+(0)+" : "+message);
  }
%} 

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,0,(int)yychar), new Location(yyline+1,0,(int)yychar+1));
%eofval}


letra  = ([A-Z]|[a-z])
digito = [0-9]
separador = [ \t\r\b\n]
comentario = //[^\n]* 
identificador = {letra}({letra}|{digito})*
numeroEntero = ([\+\-]?{digito}{digito}*)
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
parentesisApertura = \(
parentesisCierre = \)
igual = \=

%state STRING

%%
{separador}              {}
{comentario}             {}
{identificador}          {return symbol("Identificador"  ,IDEN, yytext()); }
{numeroEntero}           {return symbol("Entero"         ,ENT,  ytext()); }
{operadorSuma}           {return symbol("Suma"           ,MAS, "+"); }
{operadorResta}          {return symbol("Resta"          ,MENOS, yytext()); }
{operadorMultiplicacion} {return symbol("Por"            ,POR, yytext()); }
{operadorDivision}       {return symbol("Dividido"       ,DIV, yytext()); }
{parentesisApertura}     {return symbol("Parentesis ap"  ,PAP, yytext()); }
{parentesisCierre}       {return symbol("Parentesis ci"  ,PCIERRE, yytext()); }
{igual}                  {return symbol("Igual"          ,IGUAL, yytext()); }
[^]                      {System.out.println("Error en fila "+(yyline+1));} 


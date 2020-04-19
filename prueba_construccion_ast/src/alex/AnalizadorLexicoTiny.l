
package alex;

import asint.ClaseLexica;

%%
%cup
%unicode
%line
%public
%class AnalizadorLexicoTiny
%type UnidadLexica

%{
%}

%eofval{
    return new UnidadLexica(yyline+1, ClaseLexica.EOF, "<EOF>");
%eofval}

%init{
%init}

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

%%
{separador}               {}
{comentario}              {}
{identificador}           {return new UnidadLexica(yyline+1, ClaseLexica.IDEN,    yytext());}
{numeroEntero}            {return new UnidadLexica(yyline+1, ClaseLexica.ENT,     yytext());}
{operadorSuma}            {return new UnidadLexica(yyline+1, ClaseLexica.MAS,     "+");}
{operadorResta}           {return new UnidadLexica(yyline+1, ClaseLexica.MENOS,   "-");}
{operadorMultiplicacion}  {return new UnidadLexica(yyline+1, ClaseLexica.POR,     "*");}
{operadorDivision}        {return new UnidadLexica(yyline+1, ClaseLexica.DIV,     "/");}
{parentesisApertura}      {return new UnidadLexica(yyline+1, ClaseLexica.PAP,     "(");}
{parentesisCierre}        {return new UnidadLexica(yyline+1, ClaseLexica.PCIERRE, ")");} 
{igual}                   {return new UnidadLexica(yyline+1, ClaseLexica.IGUAL,   "=");}
[^]                       {System.out.println("Error en fila "+(yyline+1));}  

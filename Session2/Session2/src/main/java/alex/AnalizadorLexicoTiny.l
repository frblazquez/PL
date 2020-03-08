package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
%type UnidadLexica
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

lmap    = lmap
lreduce = lreduce
lfilter = lfilter
print   = print

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = (0|{digitoPositivo})
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
parentesisApertura = \(
parentesisCierre = \)
igual = \=
coma  = \,
almohadilla = #
operadorMayor = >
operadorMenor = <
operadorDistinto = !\=
operadorIgual = \=\=
corcheteApertura = \[
corcheteCierre = \]

parteEntera = {digitoPositivo}{digito}*
separador = [ \t\r\b\n]
comentario = \/\/[^\n]* 
identificador = {letra}({letra}|{digito})*
numeroEntero = [\+\-]?{parteEntera}

%%
{separador}               {}
{comentario}              {}
{lmap}					  {return ops.unidadLMap();}
{lreduce}				  {return ops.unidadLReduce();}
{lfilter}				  {return ops.unidadLFilter();}
{print}					  {return ops.unidadPrint();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();}
{corcheteApertura}		  {return ops.unidadCAp();}
{corcheteCierre}		  {return ops.unidadCCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{almohadilla}			  {return ops.unidadAlmohadilla();}
{operadorMayor}			  {return ops.unidadMayor();}
{operadorMenor}			  {return ops.unidadMenor();}
{operadorDistinto}		  {return ops.unidadDistinto();}
{operadorIgual}           {return ops.unidadIgualIgual();} 
[^]                       {errores.errorLexico(fila(),lexema());}  

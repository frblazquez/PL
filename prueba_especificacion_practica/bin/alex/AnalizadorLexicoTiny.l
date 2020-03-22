package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
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

and = and
or = or
not = not
while = while
if = if
else = else
return = return
true = true
false = false
int = int
bool = bool
letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
separador = [ \t\r\b\n]
comentario = //[^\n]* 
identificador = {letra}({letra}|{digito})*
numeroEntero = ([\+\-]?{parteEntera}|0)
numeroReal = [\+\-]?{parteEntera}\.{parteDecimal}
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
parentesisApertura = \(
parentesisCierre = \)
igual = \=
igualigual = \=\=
coma  = \,
puntocoma = \;
mayor = >
menor = <
mayorigual = >\=
menorigual = <\=
distinto = !\=
corcheteApertura = \[
corcheteCierre = \]
llaveApertura = \{
llaveCierre = \}
%%
{separador}               {}
{comentario}              {}
{and}					  {return ops.unidadAnd();}
{or}					  {return ops.unidadOr();}
{not}					  {return ops.unidadNot();}
{while}					  {return ops.unidadWhile();}
{if}					  {return ops.unidadIf();}
{else}					  {return ops.unidadElse();}
{return}				  {return ops.unidadReturn();}
{true}					  {return ops.unidadTrue();}
{false}					  {return ops.unidadFalse();}
{int}					  {return ops.unidadInt();}
{bool}					  {return ops.unidadBool();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();}
{igualigual}			  {return ops.unidadIgualIgual();} 
{coma}                    {return ops.unidadComa();}
{puntocoma}				  {return ops.unidadPuntoComa();}
{mayor}					  {return ops.unidadMayor();}
{menor}					  {return ops.unidadMenor();}
{mayorigual}			  {return ops.unidadMayorIgual();}
{menorigual}			  {return ops.unidadMenorIgual();}
{distinto}				  {return ops.unidadDistinto();}
{corcheteApertura}		  {return ops.unidadCAp();}
{corcheteCierre}		  {return ops.unidadCCierre();}
{llaveApertura}			  {return ops.unidadLAp();}
{llaveCierre}			  {return ops.unidadLCierre();}
[^]                       {errores.errorLexico(fila(),lexema());}  
package alex;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

separador = [\t\r\b\n]
especiales = [^a-zA-Z\t\r\b\n]
letra  = ([A-Z]|[a-z])
palabra = {letra}+
patron = ({palabra})?\*({palabra})?
otro = (({especiales})*({patron})+({especiales})*({patron})+({especiales})*|({palabra})*([^a-zA-Z\t\r\b\n])+({palabra})*) 
parentesisApertura = \(
parentesisCierre = \)
igual = \=
coma  = \,
%%

{separador}               {}
{palabra}				  {return ops.unidadPalabra();}
{patron}				  {return ops.unidadPatron();}
{otro}					  {return ops.unidadOtro();} 	
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
[^]                       {ops.error();}  
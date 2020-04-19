// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import errors.GestionErroresTiny;

%%

%public
%class Lexer
%cup
%implements sym
%char
%line
%column

%{
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }

    StringBuffer string = new StringBuffer();
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,(int)yychar), new Location(yyline+1,yycolumn+yylength(),(int)yychar+yylength()));
  }
  
  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline+1,yycolumn+1,(int)yychar);
      Location right= new Location(yyline+1,yycolumn+yylength(), (int)yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  } 
  private Symbol symbol(String name, int sym, Object val,int buflength) {
      Location left = new Location(yyline+1,yycolumn+yylength()-buflength,(int)yychar+yylength()-buflength);
      Location right= new Location(yyline+1,yycolumn+yylength(), (int)yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  }       
  private void error(String message) {
    System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
  }
%} 

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,yycolumn+1,(int)yychar), new Location(yyline+1,yycolumn+1,(int)yychar+1));
%eofval}

%state STRING

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
switch = switch
case = case
default = default
void = void
main = main
null = null
letra  = ([A-Z]|[a-z])
digito = [0-9]
separador = [ \t\r\b\n]
comentario = \/\/[^\n]* 
identificador = {letra}({letra}|{digito}|{barrabaja})*
numeroEntero = ([\+\-]?{digito}{digito}*)
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
parentesisApertura = \(
parentesisCierre = \)
ampersand = &
igual = \=
igualigual = \=\=
barrabaja = _
coma  = \,
punto = \.
puntocoma = \;
dospuntos = \:
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
{and}					  {return symbol("and", AND, "and");}
{or}					  {return symbol("or", OR, "or");}
{not}					  {return symbol("not", NOT, "not");}
{while}					  {return symbol("while", WHILE, "while");}
{if}					  {return symbol("if", IF, "while");}
{else}					  {return symbol("else", ELSE, "while");}
{return}				  {return symbol("return", RETURN, "while");}
{true}					  {return symbol("true", TRUE, "while");}
{false}					  {return symbol("false", FALSE, "while");}
{int}					  {return symbol("int", INT, "while");}
{bool}					  {return symbol("bool", BOOL, "while");}
{switch}				  {return symbol("switch", SWITCH, "while");}
{case}					  {return symbol("case", CASE, "while");}
{default}				  {return symbol("default", DEFAULT, "while");}
{void}					  {return symbol("void", VOID, "while");}
{main}					  {return symbol("main", MAIN, "while");}
{null}                    {return symbol("null", NULL, "while");}  
{identificador}           {return symbol("identificador", IDEN, yytext());}
{numeroEntero}            {return symbol("numeroEntero", ENT, yytext());}
{operadorSuma}            {return symbol("operadorSuma", MAS, "while");}
{operadorResta}           {return symbol("operadorResta", MENOS, "while");}
{operadorMultiplicacion}  {return symbol("operadorMultiplicacion", POR, "while");}
{operadorDivision}        {return symbol("operadorDivision", DIV, "while");}
{parentesisApertura}      {return symbol("parentesisApertura", PAP, "while");}
{parentesisCierre}        {return symbol("parentesisCierre", PCIERRE, "while");} 
{ampersand}               {return symbol("ampersand", AMPERSAND, "while");}
{igual}                   {return symbol("igual", IGUAL, "while");}
{igualigual}			  {return symbol("igualigual", IGUALIGUAL, "while");} 
{coma}                    {return symbol("punto", COMA, "while");}
{punto}					  {return symbol("while", PUNTO, "while");}
{puntocoma}				  {return symbol("puntocoma", PUNTOCOMA, "while");}
{dospuntos}				  {return symbol("dospuntos", DOSPUNTOS, "while");}
{mayor}					  {return symbol("mayor", MAYOR, "while");}
{menor}					  {return symbol("menor", MENOR, "while");}
{mayorigual}			  {return symbol("mayorigual", WHILE, "while");}
{menorigual}			  {return symbol("menorigual", MENORIGUAL, "while");}
{distinto}				  {return symbol("distinto", DISTINTO, "while");}
{corcheteApertura}		  {return symbol("[", CAP, "[");}
{corcheteCierre}		  {return symbol("]", CCIERRE, "]");}
{llaveApertura}			  {return symbol("{", LAP, "{");}
{llaveCierre}			  {return symbol("}", LCIERRE, "}");}
[^]                       {errores.errorLexico(fila(),lexema());} 


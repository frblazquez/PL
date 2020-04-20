
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Sat Mar 21 13:52:06 CET 2020
//----------------------------------------------------

package asint;

import java_cup.runtime.*;
import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;
import errors.GestionErroresTiny;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Sat Mar 21 13:52:06 CET 2020
  */
public class AnalizadorSintacticoTiny extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoTiny() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\037\000\002\002\003\000\002\002\004\000\002\003" +
    "\004\000\002\003\002\000\002\004\005\000\002\004\004" +
    "\000\002\005\003\000\002\005\005\000\002\006\005\000" +
    "\002\006\003\000\002\006\005\000\002\006\003\000\002" +
    "\007\003\000\002\007\003\000\002\010\003\000\002\010" +
    "\005\000\002\010\002\000\002\013\003\000\002\013\003" +
    "\000\002\013\003\000\002\011\003\000\002\011\003\000" +
    "\002\011\003\000\002\011\003\000\002\012\003\000\002" +
    "\012\003\000\002\012\003\000\002\012\003\000\002\014" +
    "\006\000\002\015\005\000\002\016\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\010\002\ufffe\004\004\005\007\001\002\000" +
    "\016\005\016\015\015\017\017\022\013\023\025\024\024" +
    "\001\002\000\004\002\062\001\002\000\010\002\ufffe\004" +
    "\004\005\007\001\002\000\004\013\011\001\002\000\004" +
    "\002\001\001\002\000\016\005\016\015\015\017\017\022" +
    "\013\023\025\024\024\001\002\000\020\002\uffef\004\uffef" +
    "\005\uffef\014\uffef\016\uffef\020\uffef\021\uffef\001\002\000" +
    "\012\025\056\026\055\027\054\030\053\001\002\000\020" +
    "\002\uffee\004\uffee\005\uffee\014\uffee\016\uffee\020\uffee\021" +
    "\uffee\001\002\000\016\005\016\015\015\017\017\022\013" +
    "\023\025\024\024\001\002\000\020\002\ufff8\004\ufff8\005" +
    "\ufff8\014\ufff8\016\ufff8\020\ufff8\021\ufff8\001\002\000\022" +
    "\005\016\006\041\015\015\017\017\020\ufff1\022\013\023" +
    "\025\024\024\001\002\000\020\002\ufff0\004\ufff0\005\ufff0" +
    "\014\ufff0\016\ufff0\020\ufff0\021\ufff0\001\002\000\020\002" +
    "\ufffb\004\ufffb\005\ufffb\014\ufffb\016\ufffb\020\ufffb\021\037" +
    "\001\002\000\010\002\ufffd\004\ufffd\005\ufffd\001\002\000" +
    "\020\002\ufff6\004\ufff6\005\ufff6\014\ufff6\016\ufff6\020\ufff6" +
    "\021\ufff6\001\002\000\012\007\026\010\030\011\032\012" +
    "\031\001\002\000\012\007\026\010\030\011\032\012\031" +
    "\001\002\000\020\005\uffe9\006\uffe9\015\uffe9\017\uffe9\022" +
    "\uffe9\023\uffe9\024\uffe9\001\002\000\004\006\033\001\002" +
    "\000\020\005\uffe8\006\uffe8\015\uffe8\017\uffe8\022\uffe8\023" +
    "\uffe8\024\uffe8\001\002\000\020\005\uffe6\006\uffe6\015\uffe6" +
    "\017\uffe6\022\uffe6\023\uffe6\024\uffe6\001\002\000\020\005" +
    "\uffe7\006\uffe7\015\uffe7\017\uffe7\022\uffe7\023\uffe7\024\uffe7" +
    "\001\002\000\016\005\016\015\015\017\017\022\013\023" +
    "\025\024\024\001\002\000\020\002\uffe3\004\uffe3\005\uffe3" +
    "\014\uffe3\016\uffe3\020\uffe3\021\uffe3\001\002\000\016\005" +
    "\016\015\015\017\017\022\013\023\025\024\024\001\002" +
    "\000\020\002\uffe4\004\uffe4\005\uffe4\014\uffe4\016\uffe4\020" +
    "\uffe4\021\uffe4\001\002\000\016\005\016\015\015\017\017" +
    "\022\013\023\025\024\024\001\002\000\016\002\ufffa\004" +
    "\ufffa\005\ufffa\014\ufffa\016\ufffa\020\ufffa\001\002\000\006" +
    "\014\ufff5\020\ufff5\001\002\000\006\014\046\020\ufff3\001" +
    "\002\000\006\014\ufff4\020\ufff4\001\002\000\004\020\045" +
    "\001\002\000\020\002\ufff7\004\ufff7\005\ufff7\014\ufff7\016" +
    "\ufff7\020\ufff7\021\ufff7\001\002\000\022\005\016\006\041" +
    "\015\015\017\017\020\ufff1\022\013\023\025\024\024\001" +
    "\002\000\004\020\ufff2\001\002\000\004\016\051\001\002" +
    "\000\020\002\ufff9\004\ufff9\005\ufff9\014\ufff9\016\ufff9\020" +
    "\ufff9\021\ufff9\001\002\000\004\006\057\001\002\000\004" +
    "\006\uffeb\001\002\000\004\006\uffea\001\002\000\004\006" +
    "\uffec\001\002\000\004\006\uffed\001\002\000\016\005\016" +
    "\015\015\017\017\022\013\023\025\024\024\001\002\000" +
    "\020\002\uffe5\004\uffe5\005\uffe5\014\uffe5\016\uffe5\020\uffe5" +
    "\021\uffe5\001\002\000\004\002\uffff\001\002\000\004\002" +
    "\000\001\002\000\010\002\ufffc\004\ufffc\005\ufffc\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\010\002\004\003\007\004\005\001\001\000" +
    "\016\005\062\006\020\013\022\014\017\015\011\016\013" +
    "\001\001\000\002\001\001\000\006\003\060\004\005\001" +
    "\001\000\002\001\001\000\002\001\001\000\016\005\021" +
    "\006\020\013\022\014\017\015\011\016\013\001\001\000" +
    "\002\001\001\000\004\011\051\001\001\000\002\001\001" +
    "\000\016\005\047\006\020\013\022\014\017\015\011\016" +
    "\013\001\001\000\002\001\001\000\022\005\042\006\020" +
    "\007\041\010\043\013\022\014\017\015\011\016\013\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\012\034\001\001\000\004\012" +
    "\026\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\014\006" +
    "\033\013\022\014\017\015\011\016\013\001\001\000\002" +
    "\001\001\000\014\006\035\013\022\014\017\015\011\016" +
    "\013\001\001\000\002\001\001\000\014\006\037\013\022" +
    "\014\017\015\011\016\013\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\022\005\042\006\020\007" +
    "\041\010\046\013\022\014\017\015\011\016\013\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\006\057\013\022\014" +
    "\017\015\011\016\013\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoTiny$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoTiny$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoTiny$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErroresTiny();
   AnalizadorLexicoTiny alex = (AnalizadorLexicoTiny)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresTiny errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoTiny$actions {
  private final AnalizadorSintacticoTiny parser;

  /** Constructor */
  CUP$AnalizadorSintacticoTiny$actions(AnalizadorSintacticoTiny parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action_part00000000(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoTiny$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= LInst 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("S",0, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoTiny$stack.elementAt(CUP$AnalizadorSintacticoTiny$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoTiny$parser.done_parsing();
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LInst ::= Inst LInst 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("LInst",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LInst ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("LInst",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Inst ::= IDEN IGUAL Lista1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Inst",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Inst ::= PRINT Lista1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Inst",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Lista1 ::= Lista2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista1",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Lista1 ::= Lista2 ALMOHADILLA Lista2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista1",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Lista2 ::= PAP Lista1 PCIERRE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista2",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Lista2 ::= IDEN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista2",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Lista2 ::= CAP SucEls CCIERRE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista2",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Lista2 ::= OpLista 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Lista2",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Elemento ::= ENT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Elemento",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Elemento ::= Lista1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Elemento",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // SucEls ::= Elemento 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("SucEls",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // SucEls ::= Elemento COMA SucEls 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("SucEls",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // SucEls ::= 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("SucEls",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // OpLista ::= LFilter 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpLista",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // OpLista ::= LReduce 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpLista",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // OpLista ::= LMap 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpLista",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // OpRel ::= MAYOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpRel",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // OpRel ::= MENOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpRel",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OpRel ::= IGUALIGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpRel",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OpRel ::= DISTINTO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpRel",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OpArit ::= MAS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpArit",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OpArit ::= MENOS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpArit",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // OpArit ::= POR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpArit",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // OpArit ::= DIV 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OpArit",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // LFilter ::= LFILTER OpRel ENT Lista2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("LFilter",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // LReduce ::= LREDUCE OpArit Lista2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("LReduce",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // LMap ::= LMAP OpArit ENT Lista2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("LMap",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintacticoTiny$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintacticoTiny$do_action_part00000000(
                               CUP$AnalizadorSintacticoTiny$act_num,
                               CUP$AnalizadorSintacticoTiny$parser,
                               CUP$AnalizadorSintacticoTiny$stack,
                               CUP$AnalizadorSintacticoTiny$top);
    }
}

package alex;

import asint.ClaseLexica;
import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
   
	private int fila;
	private ClaseLexica clase;
   
	public UnidadLexica(int fila, int clase, String lexema) {
		super(clase, lexema);
		this.fila   = fila;
	}
   
	public ClaseLexica clase () {return clase;}
	public String lexema() {return (String)value;}
	public int fila() {return fila;}
}

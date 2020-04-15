java JLex.Main src/alex/AnalizadorLexicoTiny.l

NFILE=src/alex/AnalizadorLexicoTiny.l.java
OFILE=src/alex/AnalizadorLexicoTiny.java

if test -f $NFILE; then
	mv $NFILE $OFILE
fi
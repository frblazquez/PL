# Script for the automatic generation of the lexical analyzer. Run this every 
# time lexical specification (src/alex/AnalizadorLexicoTiny.l) is modified.

java -cp jlex.jar JLex.Main src/alex/AnalizadorLexicoTiny.l

NFILE=src/alex/AnalizadorLexicoTiny.l.java
OFILE=src/alex/AnalizadorLexicoTiny.java

if test -f $NFILE; then
	mv $NFILE $OFILE
fi


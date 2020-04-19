# Script for the automatic generation of the lexical analyzer. Run this every 
# time lexical specification (src/alex/AnalizadorLexicoTiny.l) is modified.

java -cp jars/jlex.jar JLex.Main minijava.l

NFILE=minijava.l.java
OFILE=../java/alex/Lexer.java

if test -f $NFILE; then
	mv $NFILE $OFILE
fi


# Script for the automatic generation of the lexical analyzer. Run this every 
# time sintactical specification (src/asint/AnalizadorSintacticoTiny.cup) is modified.

java -jar cup.jar -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions src/asint/Tiny.cup

FILE1=AnalizadorSintacticoTiny.java
FILE2=ClaseLexica.java

if test -f $FILE1; then
    # mv will automatically override old files, commented to avoid error msgs if no file is present
    # rm src/asint/$FILE1
	# rm src/asint/$FILE2
	mv $FILE1 src/asint/$FILE1
	mv $FILE2 src/asint/$FILE2
fi


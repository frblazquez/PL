# Lexical analyzer generation
jflex minijava.jflex
mv Lexer.java ../java/alex/Lexer.java

# Syntax analyzer generation
java -jar jars/java-cup-11b.jar -locations -interface -parser Parser -xmlactions minijava.cup
mv Parser.java ../java/asint/Parser.java
mv sym.java ../java/asint/sym.java


#java -cp ../../dist/java-cup-11b-runtime.jar:. Parser simple.minijava simple.xml /
#basex codegen.sq output.xml > simple.minijvm

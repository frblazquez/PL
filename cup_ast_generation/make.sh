# Clean
rm ast.html
cd output/
rm *
cd ../src/
rm Lexer.java sym.java Parser.java

# Lexycal analyzer generation
cd ../configs/
jflex minijava.jflex
mv Lexer.java ../src/Lexer.java

# Syntax analyzer generation
java -jar ../jars/java-cup-11b.jar -locations -interface -parser Parser -xmlactions minijava.cup
mv sym.java ../src/sym.java
mv Parser.java ../src/Parser.java

#javac -cp ./jars/java-cup-11b-runtime.jar:. *.java
#java -cp  ./jars/java-cup-11b-runtime.jar:. Parser input.txt simple.xml /
#basex codegen.sq output.xml > simple.minijvm

# Back to main folder
cd ..


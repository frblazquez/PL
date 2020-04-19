# Syntax analyzer generation
java -jar jars/java-cup-11b.jar -locations -interface -parser Parser -xmlactions aux.cup
mv Parser.java ../java/asint/Parser.java
mv sym.java ../java/asint/sym.java

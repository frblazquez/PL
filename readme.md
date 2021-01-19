# Language Processors

Development of a custom c-style language processor. It includes lexical, syntactical and static-semantics analyzers including 
error recovery techniques and code generation for the abstract p-machine.

## Repository structure

* **Session1:** Lexical analyzer construction with [JLex](https://www.cs.princeton.edu/~appel/modern/java/JLex/).
* **Session2:** Syntactical analyzer construction with [CUP](https://www.cs.princeton.edu/~appel/modern/java/CUP/manual.html).
* **frabit:** Custom full language processor.

## frabit language specifications

Frabit is our language processor. It reads from a file a program, checks its lexical, syntactical and semantical correction and, 
if correct, generates the code for the abstract p-machine of the program. If the program given is not correct error recovery
techniques are applied in order to continue the analysis and detect as much errors as possible. 

The rules applied by the analyzers as well as the format of the generated resulting code is given by:

* **Lexical specification:** [JLex specification](frabit/src/alex/AnalizadorLexicoTiny.l), package alex.
* **Syntactical specification:** [CUP specification](frabit/src/Asint/AnalizadorSintacticoTiny.cup) package asint.
* **Errors management:** [Error management](frabit/src/errors/GestionErroresTiny.java) package errors.
* **Semantical specification:** [docs/frabit_specification.pdf](frabit/docs/frabit_specification.pdf), package asem and AST.  
* **P-Machine code generation:** [docs/p-machine_instructions.pdf](frabit/docs/p-machine_instructions.pdf), package code and AST. 

## frabit execution

```
# Clone the repo
git clone https://github.com/frblazquez/PL.git

# Place JLex and CUP jars in PL/frabit/ and then run the analyzers generation scripts
cd PL/frabit/
./jlex.sh 
./cup.sh

# Compile the java code (requires JLex and CUP in the classpath) and run the tests
./run_testfiles.sh
```

It's strictly necessary to run the test script for generating the [p-machine interpreter](frabit/p-machine/). After this, 
the configuration is complete and it's possible to compile frabit code running the [Main](frabit/src/main/Main.java), it
accepts as arguments the input and desired output files. This output file can be run in the p-machine interpreter.


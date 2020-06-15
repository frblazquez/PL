#!/bin/bash

# Automatic generation of p-machine runner if not generated yet
if [ ! -f p-machine/Main ]; then
    cd p-machine
    ghc Main.hs
    cd ..
fi

# Run and check the return value over all the test files
BASIC_RESULTS=(5 3 17 1 7 7 7 5 3 10 11 0 17 9 1 7 1 7 25 13 17)
EXPRESSIONS_RESULTS=(165 153 4 5 9 223)
TYPES_RESULTS=(7 111 1 7 1 4)
POINTERS_RESULTS=(6 1 15 7 11)
DINAMICMEM_RESULTS=(1 14 1 1 1 1)
SUBROUTINES_RESULTS=(1 2 1 1 11 1 1 1 1 1 1 5)

declare -i i=0
FILES=test-files/code-gen/basic/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}
    
    if [ "$returnvalue" = "${BASIC_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

i=$((0))
FILES=test-files/code-gen/expressions/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}
    
    if [ "$returnvalue" = "${EXPRESSIONS_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

i=$((0))
FILES=test-files/code-gen/types/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}
    
    if [ "$returnvalue" = "${TYPES_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

i=$((0))
FILES=test-files/code-gen/pointers/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}
    
    if [ "$returnvalue" = "${POINTERS_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

i=$((0))
FILES=test-files/code-gen/dinamic-mem/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}
    
    if [ "$returnvalue" = "${DINAMICMEM_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

i=$((0))
FILES=test-files/code-gen/subroutines/*
for file in $FILES ; do
	echo Processing $file
    java -classpath ".:bin/:cup.jar" main.Main $file > p-machine/input.txt
    p-machine/Main p-machine/input.txt > p-machine/output.txt
    return=`sed '5q;d' p-machine/output.txt`
    returnvalue=${return:7:-1}

    if [ "$returnvalue" = "${SUBROUTINES_RESULTS[i]}" ]; then
        echo "Test OK"
    else 
        echo "Test FAILED!"
    fi
    i=$((i + 1))
done

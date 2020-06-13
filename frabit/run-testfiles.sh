#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
#FILES=test-files/code-gen/basic/*.txt ;
FILES=test-files/code-gen/basic/*.txt
for file in $FILES ; do
	cd $DIR
	echo Processing $file
	java -jar frabit-compiler.jar $file > pcode
	cd $DIR/../pmachine/
	echo :main $DIR/pcode | ghci Main.hs
	rm $DIR/pcode
done
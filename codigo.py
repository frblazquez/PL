X = ['ADD',
	'SUB',
	'MUL',
	'DIV',
	'NEG',
	'AND',
	'OR',
	'NOT',
	'EQU',
	'GEQ',
	'LEQ',
	'LES',
	'GRT',
	'NEQ',
	'LDO',
	'LDC',
	'IND',
	'SRO',
	'STO',
	'UJP',
	'FJP',
	'IXJ',
	'IXA',
	'INC',
	'DEC',
	'CHK',
	'DPL',
	'LDD',
	'SLI',
	'NEW',
	'LOD',
	'LDA',
	'STR',
	'MST',
	'CUP',
	'SSP',
	'SEP',
	'ENT',
	'RETF',
	'RETP',
	'MOVS',
	'MOVD',
	'SMP',
	'CUPI',
	'MSTF',
	'STP']

str = "switch(this) {"
for i in X:
	str += '\n case ' + i + ':' + ' return' + '\"' + i.lower() + '\"' + ';'
print(str + '}')
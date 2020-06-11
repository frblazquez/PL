package code;

public enum PMachineInstructions {
	ADD,
	SUB,
	MUL,
	DIV,
	NEG,
	AND,
	OR,
	NOT,
	EQU,
	GEQ,
	LEQ,
	LES,
	GRT,
	NEQ,
	LDO,
	LDC,
	IND,
	SRO,
	STO,
	UJP,
	FJP,
	IXJ,
	IXA,
	INC,
	DEC,
	CHK,
	DPL,
	LDD,
	SLI,
	NEW,
	LOD,
	LDA,
	STR,
	MST,
	CUP,
	SSP,
	SEP,
	ENT,
	RETF,
	RETP,
	MOVS,
	MOVD,
	SMP,
	CUPI,
	MSTF,
	STP,
	DELETEME;
	
	public String toString()
	{
		switch(this) {
		 case ADD: return"add";
		 case SUB: return"sub";
		 case MUL: return"mul";
		 case DIV: return"div";
		 case NEG: return"neg";
		 case AND: return"and";
		 case OR: return"or";
		 case NOT: return"not";
		 case EQU: return"equ";
		 case GEQ: return"geq";
		 case LEQ: return"leq";
		 case LES: return"les";
		 case GRT: return"grt";
		 case NEQ: return"neq";
		 case LDO: return"ldo";
		 case LDC: return"ldc";
		 case IND: return"ind";
		 case SRO: return"sro";
		 case STO: return"sto";
		 case UJP: return"ujp";
		 case FJP: return"fjp";
		 case IXJ: return"ixj";
		 case IXA: return"ixa";
		 case INC: return"inc";
		 case DEC: return"dec";
		 case CHK: return"chk";
		 case DPL: return"dpl";
		 case LDD: return"ldd";
		 case SLI: return"sli";
		 case NEW: return"new";
		 case LOD: return"lod";
		 case LDA: return"lda";
		 case STR: return"str";
		 case MST: return"mst";
		 case CUP: return"cup";
		 case SSP: return"ssp";
		 case SEP: return"sep";
		 case ENT: return"ent";
		 case RETF: return"retf";
		 case RETP: return"retp";
		 case MOVS: return"movs";
		 case MOVD: return"movd";
		 case SMP: return"smp";
		 case CUPI: return"cupi";
		 case MSTF: return"mstf";
		 case STP: return"stp";
		 case DELETEME: return "{------------------------------------------------------------}";
		 default: return "";
		 }
	}
}



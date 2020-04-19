package main;

public class Main {

    public static final String INPUT_FILE = "input.txt";

// MAIN FOR SYNTAX ANALYSIS
//
//    public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
//
//	// Lexical analyzer initialization
//	Reader input = new InputStreamReader(new FileInputStream(INPUT_FILE));
//	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
//
//	// Syntax analyzer initialization
//	AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
//	asint.parse();
//
//    }

// MAIN FOR AST GENERATION IN HTML FORMAT (WIP)    
//
//    public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
//
//	// Lexical analyzer initialization
//	Reader input = new InputStreamReader(new FileInputStream(INPUT_FILE));
//	AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
//
//	// initialize the symbol factory
//	ComplexSymbolFactory csf = new ComplexSymbolFactory();
//	// create a buffering scanner wrapper
//	ScannerBuffer lexer = new ScannerBuffer(alex);
//	// start parsing
//	AnalizadorSintacticoTiny p = new AnalizadorSintacticoTiny(lexer, csf);
//	XMLElement e = (XMLElement) p.parse().value;
//	// create XML output file
//	XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
//	XMLStreamWriter sw = outFactory.createXMLStreamWriter(new FileOutputStream(args[1]));
//	// dump XML output to the file
//	XMLElement.dump(lexer, sw, e, "expr", "stmt");
//
//	// transform the parse tree into an AST and a rendered HTML version
//	Transformer transformer = TransformerFactory.newInstance()
//		.newTransformer(new StreamSource(new File("tree.xsl")));
//	Source text = new StreamSource(new File(args[1]));
//	transformer.transform(text, new StreamResult(new File("output.xml")));
//	transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new File("tree-view.xsl")));
//	text = new StreamSource(new File("output.xml"));
//	transformer.transform(text, new StreamResult(new File("ast.html")));
//
//    }

// MAIN FOR LEXICAL ANALYSIS
//
//    public static void main(String[] args) throws IOException {
//	Reader input = new InputStreamReader(new FileInputStream(INPUT_FILE));
//	AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
//	UnidadLexica unidad;
//	do {
//	    unidad = al.next_token();
//	    System.out.println(unidad.value);
//	} while(unidad.clase() != ClaseLexica.EOF);
//    }

}

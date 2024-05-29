package parser;

/**Parser class reads in lexical analyzer output and prints parse tree. 
 * 
 * @author Brian Baker
 *
 */
public class Parser extends Node {
	String token;
	
	/**Constructor for parser class. Uses Node class and stores tokens. 
	 * 
	 * @param token
	 */
	public Parser(String token) {
		super(token);
		this.token = token;
	}
	/**Takes token data and turns it into bottom up traversal. This is stored as a parsetree. 
	 * parsetree is then formated into formatedParseTree. 
	 * 
	 * @precondition: none
	 * @postcondition: formated parse tree     
	 * 
	 * @return formatedParseTree
	 */
	public String printParseTree() {
		String parseTree = this.token;
		String formatedparseTree = "";
		Node node = new Node(this.token);
		Node.Tree tree = node.new Tree();
		tree.addRoot(this.token);
		for(char c : this.token.toCharArray()) {
			node.insertToken("" + c);
		}
		parseTree = tree.traverse(tree.root);
		
		char tokens[] = this.token.toCharArray();
		
		if(parseTree.contains("Run")) {
			formatedparseTree += "<program> -> <keyword> Run { ";
		
		}
		
		for(int i = 0; i < parseTree.length(); i++) {
			if(parseTree.charAt(i) == ';') {
				formatedparseTree += "<statement>";
			}
		}
		formatedparseTree += "} \n";
		formatedparseTree += "{ \n";
		
		if(parseTree.contains(";") && parseTree.contains("<id>") && parseTree.contains("+")) {
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> <arithmetic_expression> \n";
		}	
		
		if(parseTree.contains(";") && parseTree.contains("<id>") && parseTree.contains("-")) {
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> <arithmetic_expression> \n";
		}	
		
		if(parseTree.contains(";") && parseTree.contains("<id>") && parseTree.contains("*")) {
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> <arithmetic_expression> \n";
		}	
		
		if(parseTree.contains(";") && parseTree.contains("<id>") && parseTree.contains("/")) {
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";	
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> \n";
			formatedparseTree += "<statement> -> <assignment_statement> \n";
			formatedparseTree += "<assignment_statement> -> id <assignment_operator> <integer> <arithmetic_expression> \n";
		}	
		
		
		
		
		if(parseTree.contains("+")) {
			formatedparseTree += "<statement> -> <integer> <plus_operator> <integer> id \n"; 
		}
		
		if(parseTree.contains("-")) {
			formatedparseTree += "<statement> -> <integer> <subtract_operator> <integer> id \n"; 
		}
		
		if(parseTree.contains("*")) {
			formatedparseTree += "<statement> -> <integer> <multiplication_operator> <integer> id \n"; 
		}
		
		
		if(parseTree.contains("/")) {
			formatedparseTree += "<statement> -> <integer> <division_operator> <integer> id \n"; 
		}
		
		if(parseTree.contains("print") && parseTree.contains("+") && parseTree.contains("<id>")) {
			formatedparseTree += "<statement> -> <print_statement> \n";
			formatedparseTree += "<print_statement> -> print <arithmetic_expresssion> \n";
			formatedparseTree += "<arithmetic_expression> -> id \n";
		}
		
		if(parseTree.contains("print") && parseTree.contains("-") && parseTree.contains("<id>")) {
			formatedparseTree += "<statement> -> <print_statement> \n";
			formatedparseTree += "<print_statement> -> print <arithmetic_expresssion> \n";
			formatedparseTree += "<arithmetic_expression> -> id \n";
		}
		
		if(parseTree.contains("print") && parseTree.contains("*") && parseTree.contains("<id>")) {
			formatedparseTree += "<statement> -> <print_statement> \n";
			formatedparseTree += "<print_statement> -> print <arithmetic_expresssion> \n";
			formatedparseTree += "<arithmetic_expression> -> id \n";
		}
		
		if(parseTree.contains("print") && parseTree.contains("/") && parseTree.contains("<id>")) {
			formatedparseTree += "<statement> -> <print_statement> \n";
			formatedparseTree += "<print_statement> -> print <arithmetic_expresssion> \n";
			formatedparseTree += "<arithmetic_expression> -> id \n";
		}
		
		if(parseTree.contains("}")) {
			formatedparseTree += "}";
			
		}
		return formatedparseTree;
}
}


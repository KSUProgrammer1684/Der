package scanner;
/**This is a lexical analyzer (scanner) class. 
 * This class has several instance variables 
 * used to process and store tokens. 
 * 
 * @author Brian L. Baker
 *
 */
public class LexicalAnalyzer {
	public String keywords[] = {"class", "Run", "void", "print", "int", "double"};
	public String id[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
			"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
			"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"};
	public String literal_integer[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public String assignment_operator = "=";
	public String le_operator = "<=";
	public String lt_operator = "<";
	public String ge_operator = ">=";
	public String gt_operator = ">";
	public String eq_operator = "==";
	public String ne_operator = "!=";
	public String add_operator = "+";
	public String sub_operator = "-";
	public String mul_operator = "*";
	public String div_operator = "/";
	public String mod_operator = "%";
	public String rev_div_operator = "\"";
	public String exp_operator = "^";
	public String operators[] = {"{", "}", ";"};
	private String token;
	char [] lexemes;
	
	/**This is a constructor for the class LexicalAnalyzer. 
	 * A scanner is suppose to read in one character at a time. 
	 * I had to convert input to an array of characters   
	 * 
	 * @param input
	 */
	public LexicalAnalyzer(String input){
		this.lexemes = input.toCharArray();  	
		this.setToken(this.lexemes);
	}
	
	/**This is a setter for token. 
	 * 
	 * @param: lexeme
	 * @precondition: none
	 * @postcondition: none 
	 */
	public void setToken(char[] lexeme) {
		String keywords[] = {"class", "Run", "void", "print", "int", "double"};
		
		for(char s : lexeme) {
			for(int i = 0; i < this.id.length; i++) {
				if(s == this.id[i].charAt(0)) {
					this.token += "<id> " + s + "\n";
				}
			}
		
		
			for(int a = 0; a < this.literal_integer.length; a++) {
				if(s == this.literal_integer[a].charAt(0)) {
					this.token += "<literal_integer> " + s + "\n"; 
				}
			}
				
			for(int b = 0; b < this.keywords.length; b++) {				
				if(s == this.keywords[b].charAt(0)) {
					this.token += "<keywords> " + keywords[b] + "\n";
				}
			}
			
			for(int c = 0; c < this.operators.length; c++) {
				if(s == this.operators[c].charAt(0)) {
					this.token += "<operator> " + s + "\n";
				}
			}
		
			
			if(s == this.assignment_operator.charAt(0)) {
				this.token += "<assignment_operator> " + s + "\n";
			}
				
	        if(s == this.le_operator.charAt(0)) {	
	        	this.token += "<le_operator> " + s + "\n";
	        }
			
			
			if(s == this.lt_operator.charAt(0)) {
				this.token += "<lt_operator> " + s + "\n";
			}
			
				
			if(s == this.ge_operator.charAt(0)) {
				this.token += "<ge_operator> " + s + "\n";
			}
			
			if(s == this.gt_operator.charAt(0)) {
				this.token += "<gt_operator> " + s + "\n";
			}
			
			if(s == this.eq_operator.charAt(0)) {
				this.token += "<eq_operator> " + s + "\n";
			}
			
			if(s == this.ne_operator.charAt(0)) {
				this.token += "<ne_operator> " + s + "\n";
			}
			
			if(s == this.add_operator.charAt(0)) {
				this.token += "<add_operator> " + s + "\n";
			}
			
			if(s == this.sub_operator.charAt(0)) {
				this.token += "<sub_operator> " + s + "\n";
			}
			
			if(s == this.mul_operator.charAt(0)) {
				this.token += "<mul_operator> " + s + "\n";
			}
			
			if(s == this.div_operator.charAt(0)) {
				this.token += "<div_operator> " + s + "\n";
			}
			
			if(s== this.mod_operator.charAt(0)) {
				this.token += "<mod_operator> " + s + "\n";
			}
			
			if(s == this.rev_div_operator.charAt(0)) {
				this.token += "<rev_div_operator> " + s + "\n";
			}
			
			if(s == this.exp_operator.charAt(0)) {
				this.token += "<exp_operator> " + s + "\n";
			}
					
		} 
	}
	/**This is a getter for token. 
	 * 
	 * @return token
	 * @precondition: none
	 * @postcondition: none
	 */
	public String getToken() {
		return this.token;
	}

}
	

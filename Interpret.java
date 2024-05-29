package interpreter;

import parser.Parser;
/**This class reads in token and parser data. Then runs the .txt file one character at a time. 
 * 
 * @author Brian Baker
 *
 */
public class Interpret extends Parser  {
	
	public String token;
	public String parser;
	
    /**This is a constructor for the Interpret class.
     * 
     * @param token
     * @param parser
     */
	public Interpret(String token, String parser) {
		super(token);
		this.token = token;
		this.parser = parser;
	}
	
	/**This method runs the program entered into the interpreter.
	 * @precondition: none
	 * @postcondition: none
	 * 
	 */
	public void runProgram() {
		char numbers[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int number1 = 0; 
		int number2 = 0; 
		int id3 = 0;
		char tokens[] = this.token.toCharArray();
		char statement1[] = new char[1000];
		char statement2[] = new char[1000];
		
		for(int a = 0; a < this.token.length(); a++) {
			if(statement1[a] != ';') {
				statement1[a] += tokens[a];
			} else {
				statement2[a] += tokens[a];
			}
		}
		
		for(char a : statement1) {
			for(int i = 0; i < numbers.length; i++) {
				if(a == numbers[i]) {
					number1 = this.findInt(a); 
				}
				
			}
			
		}
		
		for(char c : this.token.toCharArray()) {
			for(int o = 0; o < numbers.length; o++) {
				if(c == numbers[o]) {
					number2 = this.findInt(c);
				}
			}
		}
		
		if(this.token.contains("+")) {
			id3 = number1 + number2;
		}
		
		if(this.token.contains("-")) {
			id3 = number1 - number2;
		}
		
		if(this.token.contains("*")) {
			id3 = number1 * number2;
		}
		
		if(this.token.contains("print") && this.token.contains("+")) {
			System.out.println(id3);
		}
		
		if(this.token.contains("print") && this.token.contains("-")) {
			System.out.println(id3);
		}
		
		if(this.token.contains("print") && this.token.contains("*")) {
			System.out.println(id3);
		}
		
		if(this.token.contains("print") && this.token.contains("/")) {
			String quotent = number1 + "/" + number2;
			System.out.println(quotent);
		}
		
		boolean isInteger = false;
		for(int i = 0; i < statement1.length; i ++) {
			if(id3 == this.findInt(statement1[i])) {
				isInteger = true; 
			}
		}
		
		try {
			
			throw new Exception();
		
		}catch(Exception e) {
			if(isInteger == true) {
				System.out.println("Exception: Only int (integer) accepted!");
			} else { 
				System.out.println("Interpreter ran successfully");
			}
		}
	}
	
	/**This method converts characters to integers. 
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @param number(char)
	 * @return Integer
	 */
	public int findInt(char number) {
		char numbers[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int num = -1;
		for(int n = 0; n < numbers.length; n++ ) {
			if(numbers[n] == number) {
				num = n;
			}
			
		}
		return num; 
	}
}
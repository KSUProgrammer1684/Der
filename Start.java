package run;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import interpreter.Interpret;
import parser.Parser;
import scanner.LexicalAnalyzer;

/*
 * Name:        Brian L. Baker
 * Project:     Deliverable P3 Interpreter  
 */
public class Start {

	public static void main(String[] args) {
		String lexemes;
		// enter file path to load test file I created. 
		File code = new File("");   
		Scanner input = null;
		try {
			input = new Scanner(code);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		input.useDelimiter("//z");
		lexemes = input.next();
		System.out.println(lexemes);
		LexicalAnalyzer output = new LexicalAnalyzer(lexemes);
		
		
		System.out.println("" + output.getToken());
		System.out.println("-------------------------------------------------------");
		System.out.println("Parser \n"); 
		Parser p = new Parser("" + output.getToken());
		System.out.println(p.printParseTree());
		
		//added code below:
		System.out.println("--------------------------------------------------------");
		System.out.println("Interpreter \n");
		Interpret i = new Interpret(output.getToken(), p.printParseTree());
		System.out.println("Output of program below: ");
		i.runProgram();
	}
}

package ru.rsreu.sokolova0216;

import java.util.Scanner;

/**
 * 
 * @author Sokolova Yuliya
 *
 */
public class Runner {
	
	private Runner() {
		
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter number of strings: n = ");
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] stringArray = new String[stringCount];
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println("Enter " + (i + 1) + ". string: ");
			stringArray[i] = in.nextLine();
		}
		
		String resultString = "";
		
		for (int i = 0; i < stringCount; i++) {
			resultString = EachWordNumberCounter.countInstances(stringArray[i], resultString);
		}
		System.out.println("Execution result" + '\n' + resultString);

		in.close();
	}

}

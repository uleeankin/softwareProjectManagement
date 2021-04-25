package ru.rsreu.sokolova0220;

import java.util.Scanner;

/**
 * 
 * @author Sokolova Yuliya
 *
 */
public class ApplicationRunner {
	
	public static final String WORD = "word";
	
	private ApplicationRunner() {
		
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
		
		String result = "";
		
		for (int i = 0; i < stringCount; i++) {
			result += WordInStringSearcher.containWordCharactersMoreThanTwoTimes(stringArray[i], i);
		}
		System.out.println("Execution result" + '\n' + result);

		in.close();

	}

}

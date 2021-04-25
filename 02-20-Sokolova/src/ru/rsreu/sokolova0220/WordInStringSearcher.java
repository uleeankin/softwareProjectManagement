package ru.rsreu.sokolova0220;

/**
 * The utility class checks if a string contains all letters of the string "word" more than two times
 * @author Sokolova Yuliya
 *
 */
public class WordInStringSearcher {
	
	/**
	 * Minimum number of string "word" letter occurrences in string 
	 */
	private static final int LETTER_REPETITIONS = 2;
	/**
	 * Message text for situation when all string "word" characters are contained in string less than two times
	 */
	private static final String NEGATIVE_STRING = " doesn't contain word characters more than two times\n";
	private static final String STRING = "String ";
	/**
	 * Message text for situation when all string "word" characters are contained in string more than two times
	 */
	private static final String POSITIVE_STRING = " contains word characters more than two times\n";
	/**
	 * Message text if entered string is empty
	 */
	private static final String EMPTY_STRING = " is empty\n";
	
	private WordInStringSearcher() {
		
	}
	
	/**
	 * The method counts number of symbol occurrences in string
	 * @param symbol - a letter of the string "word"
	 * @param string - entered string
	 * @return letterRepetitions - number of symbol occurrences in string 
	 */
	private static int countLetterRepetitionsNumber(char symbol, String string) {
		int letterRepetitions = 0;
		for (int i = 0; i < string.length(); i++) {
			int symbolIndex = string.indexOf(symbol, i);
			if (symbolIndex != -1) {
				letterRepetitions++;
				i = symbolIndex;
			}
		}
		return letterRepetitions;
	}
	
	/**
	 * The method will form the result string
	 * if number of string "word" letter occurrences in string less or equal than two times
	 * @param enteredStringNumber - number of entered string
	 * @return formed string
	 */
	private static String formNegativeString(int enteredStringNumber) {
		return WordInStringSearcher.STRING + Integer.toString(enteredStringNumber + 1)
							+ WordInStringSearcher.NEGATIVE_STRING;
	}
	
	/**
	 * The method will form the result string
	 * if number of string "word" letter occurrences in string more than two times
	 * @param enteredStringNumber - number of entered string
	 * @return formed string
	 */
	private static String formPositiveString(int enteredStringNumber) {
		return WordInStringSearcher.STRING + Integer.toString(enteredStringNumber + 1)
							+ WordInStringSearcher.POSITIVE_STRING;
	}
	
	/**
	 * The method will form the result string if entered string is empty
	 * @param enteredStringNumber - number of entered string
	 * @return formed string
	 */
	private static String formEmptyStringMessage(int enteredStringNumber) {
		return WordInStringSearcher.STRING + Integer.toString(enteredStringNumber + 1)
							+ WordInStringSearcher.EMPTY_STRING;
	}
	
	/**
	 * The method checks if a string contains all letters of the string "word" more than two times
	 * @param string - the checked string
	 * @param stringNumber - number of the checked string
	 * @return result string
	 */
	public static String containWordCharactersMoreThanTwoTimes(String string, int stringNumber) {
		string.trim();
		ApplicationRunner.WORD.trim();
		if (string.length() != 0) {
			for (int i = 0; i < ApplicationRunner.WORD.length(); i++) {
				char symbol = ApplicationRunner.WORD.charAt(i);
				if (WordInStringSearcher.countLetterRepetitionsNumber(symbol, string)
						<= WordInStringSearcher.LETTER_REPETITIONS) {
					return WordInStringSearcher.formNegativeString(stringNumber);
				}
			}
			return WordInStringSearcher.formPositiveString(stringNumber);
		} else {
			return WordInStringSearcher.formEmptyStringMessage(stringNumber);
		}
	}
}

package ru.rsreu.sokolova0216;

/**
 * An utility class containing methods that count the number of instances for each word.
 * @author Sokolova Yuliya
 *
 */
public class EachWordNumberCounter {
	
	/**
	 * first instance of a word in strings
	 */
	private static final String FIRST_INSTANCE = "1";
	/**
	 * that message will be output if all entered strings are empty
	 */
	private static final String EMPTY_STRING_MESSAGE = "All strings are empty!";
	
	private EachWordNumberCounter() {
		
	}
	
	/**
	 * The method extracts a word from the result string.
	 * @param processedWord - the word for which the instances number is counted.
	 * @param result - the result string containing all words and number of their instances.
	 * @return Returns the index of the occurrence of the word being checked in the result string.
	 */
	private static int selectProcessedWordStartIndex(String processedWord, String result) {
		int beginIndex = 0;
		for (int i = beginIndex; i < result.length(); i++) {
			if (result.charAt(i) == ':') {
				if (processedWord.equals(result.substring(beginIndex, i))) {
					return beginIndex;
				}
				beginIndex = result.indexOf('\n', beginIndex) + 1;
			}
		}
		return beginIndex;
	}
	
	/**
	 * The method isWordMeets checks if a word is already in the result string or occurs for the first time.
	 * @param processedWord - the word for which the instances number is counted.
	 * @param result - the result string containing all words and number of their instances.
	 * @return Returns true if the checkedWord already exists in the result string and false if it occurs for the first time.
	 */
	private static boolean isWordOccurs(String processedWord, String result) {
		int beginIndex = 0;
		for (int i = beginIndex; i < result.length(); i++) {
			if (result.charAt(i) == ':') {
				if (processedWord.equals(result.substring(beginIndex, i))) {
					return true;
				}
				beginIndex = result.indexOf('\n', beginIndex) + 1;
			}
		}
		return false;
	}
	
	/**
	 * The method selectStringPart extracts from the result string the part containing the checked word
	 * and the number of its instances.
	 * @param result - the result string containing all words and number of their instances.
	 * @return stringPart - the part of the result string containing the checked word and the number of its instances.
	 */
	private static String selectStringPart(String processedWord, String result) {
			
		int beginIndex = EachWordNumberCounter.selectProcessedWordStartIndex(processedWord, result);
		int endIndex = result.indexOf('\n', beginIndex);
		String stringPart = result.substring(beginIndex, endIndex);
		stringPart.trim();
			
		return stringPart;
	}
	
	/**
	 * The method increaseInstancesNumber extracts from the string obtained in method selectStringPart
	 * the part containing the number of occurrences of the word and increases it by 1.
	 * @param stringPart - the part of the result string containing the checked word and the number of its instances.
	 * @return instancesNumber - increased instances number of the checked word.
	 */
	private static int increaseInstancesNumber(String stringPart) {
		int numBeginIndex = stringPart.indexOf(' ') + 1;
		int numEndIndex = stringPart.length();
		int instancesNumber = Integer.parseInt(stringPart.substring(numBeginIndex, numEndIndex)) + 1;
		
		return instancesNumber;
	}
	
	/**
	 * The method formNewString forms the string containing the checked word and the increased number of its instances.
	 * @param oldString - the string containing the checked word and not increased number of its instances.
	 * @return newString - the string containing the checked word and the increased number of its instances.
	 */
	private static String formNewString(String oldString) {
		int beginIndex = 0;
		int endIndex = oldString.indexOf(' ') + 1;
		int instancesNumber = EachWordNumberCounter.increaseInstancesNumber(oldString);
		
		String newString = oldString.substring(beginIndex, endIndex) + Integer.toString(instancesNumber);
		
		return newString;
	}
	
	/**
	 * The method formResultString changes the part of the result line containing the checked word and the number of its instances
	 * to a string containing the same word and the number of its instances increased by one.
	 * @param result - the result string containing all words and number of their instances.
	 * @param processedWord - the word for which the instances number is counted.
	 * @return result - string containing all words and number of their instances.
	 */
	private static String formResultString(String result, String processedWord) {
		if (EachWordNumberCounter.isWordOccurs(processedWord, result)) {
			
			String oldString = EachWordNumberCounter.selectStringPart(processedWord, result);
			String newString = EachWordNumberCounter.formNewString(oldString);
			
			result = result.replace(oldString, newString);
		} else {
			result = EachWordNumberCounter.checkEmptyString(result) + processedWord + ": " + FIRST_INSTANCE + '\n';
		}
		
		return result;
	}
	
	/**
	 * The method checkEmptyString empties the resulting string with the message "All strings are empty" 
	 * if there are words in the input string.
	 * @param result
	 * @return result
	 */
	private static String checkEmptyString(String result) {
		if (result.equals(EMPTY_STRING_MESSAGE)) {
			result = "";
		}
		return result;
	}
	
	/**
	 * Method countInstances count number of each word instances in all strings.
	 * @param enteredString - one of the entered lines for counting instances of each word.
	 * @param result - the result string containing all words and number of their instances.
	 * @return result
	 */
	public static String countInstances(String enteredString, String result) {	
		enteredString.trim();
		
		if (!enteredString.isEmpty()) {
			String[] processedWords = enteredString.split(" ");
			for (int i = 0; i < processedWords.length; i++) {
				processedWords[i].trim();
				result = EachWordNumberCounter.formResultString(result, processedWords[i]);
			}	
		} else if (result.isEmpty()) {
			result = EMPTY_STRING_MESSAGE;
		}
		
		return result;
	}
}

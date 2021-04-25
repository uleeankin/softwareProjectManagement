package ru.rsreu.sokolova0316;

import java.util.Arrays;

/**
 * A class that removes the element from the array,
 * shifts the elements to the right / left by one position depending on the parity of the index
 * and adds a new element.
 * 
 * @author Sokolova Yuliya
 *
 */
public class ArrayItemRemover {
	
	/**
	 * The remainder value when dividing an even number by 2
	 */
	private static final int DIVISION_REMAINDER = 0;
	private static final int PARITY_INDICATOR = 2;
	/**
	 * Array of processed elements
	 */
	private int[] items;
	
	public ArrayItemRemover(int... args) {
		this.items = new int[args.length];
		setArrayElements(args);
	}
	
	/**
	 * The method assigns the values ​​of the original array to the field items.
	 * @param args  - source array
	 */
	public final void setArrayElements(int... args) {
		for (int i = 0; i < args.length; i++) {
			this.items[i] = args[i];
		}
	}
	
	/**
	 * The method checks the INDEX value for evenness.
	 */
	private boolean isEvenValue() {
		int enteredIndex = ApplicationRunner.INDEX;
		return (enteredIndex % PARITY_INDICATOR == DIVISION_REMAINDER);
	}
	
	/**
	 * The method shifts the elements to the right of the removed one
	 * to the left by one position. The INDEX value is even.
	 */
	private void shiftElementsToTheRight() {
		int index = ApplicationRunner.INDEX - 1;
		while (index < this.items.length - 1) {
			this.items[index] = this.items[index + 1];
			index++;
		}
	}
	
	/**
	 * The method shifts the elements to the left of the removed one
	 * to the right by one position. The INDEX value is not even.
	 */
	private void shiftElementsToTheLeft() {
		int index = ApplicationRunner.INDEX - 1;
		while (index > 0) {
			this.items[index] = this.items[index - 1];
			index--;
		}
	}
	
	/**
	 * The method sets a value of adding value index.
	 * @return indexForAdding - the index of the array which the ADDING_VALUE value will be assigned.
	 */
	private int defineIndexForAdding() {
		int indexForAdding = 0;
		if (this.isEvenValue()) {
			indexForAdding = this.items.length - 1;
		}
		return indexForAdding;
	}
	
	/**
	 * The method adds  a new element to the array with the value ADDING_VALUE.
	 * @param indexForAdding - the index of the array to which the value ADDING_VALUE will be assigned.
	 */
	private void addNewItem(int indexForAdding) {
		this.items[indexForAdding] = ApplicationRunner.ADDING_VALUE;
	}
	
	/**
	 * The method removes the element with index INDEX from the array.
	 * Considering the first element is at index 1.
	 * @return the transformed array as a string.
	 */
	public String removeArrayElement() {
		if (this.isEvenValue()) {
			this.shiftElementsToTheRight();
		} else {
			this.shiftElementsToTheLeft();
		}
		this.addNewItem(this.defineIndexForAdding());
		return toString();
	}
	
	/**
	 * The override method returns the origin array as a string sequence.
	 */
	@Override
	public String toString() {
		return Arrays.toString(this.items);
	}
}

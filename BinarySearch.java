// Alan Lai
// 11/14/2019
// CSS 143
// BinarySearch Homework
/* This is BinarySearch.java. It searches through an array of words by splitting in half
 * until it finds the matching word. Using the compareTo boolean, we can see if the word is
 * to the left of the word array or right, then we divide and conquer. This can be done interatively 
 * and recursively.
 * 
 * BinarySearch has a big O of log(n).
 */
package binarySearch;
import java.util.*;

public class BinarySearch extends SearchAlgorithm {
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		// Iterative Binary Search: Has a low, mid, and high. While loop compares the word
		// middle and decides if it will cut off the left or right half of the array. Repeats
		// until the result is found, otherwise, the word isn't in the array.
		int low = 0;				// Lowest possible index.
		int mid;					// Middle index
		int high = words.length-1;	// Max index
		while(low <= high) { // Loops run as long as low is less than high	 
			incrementCount();
			mid = (low+high)/2;	// Middle of low and high
			if(wordToFind.equals(words[mid])) { // Base Case: Success
				return mid;} 
			else if(wordToFind.compareTo(words[mid]) < 0) {	// If compareTo returns negative, remove right half
				high = mid-1;}
			else if(wordToFind.compareTo(words[mid]) > 0) {	// If compareTo returns positive, remove left half
				low = mid+1;}
		}
		throw new ItemNotFoundException(wordToFind + " not found."); // If we make it out of the loop, word isn't found
	}

		
	
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		// Recursive outer facade
		// outer facade
		return recSearch(words, wordToFind, 0, words.length-1);
	}

	
	private int recSearch(String[] words, String wordToFind, int low, int high) {
		// Recursive Search: Recursive with updated Low and high
		// inner facade
		incrementCount();
		int mid = (low+high)/2;	// Mid
		if(wordToFind.compareTo(words[mid])==0) {	// Base Case: Success
			return mid;
		}
		else if(low>=high) {	// Base Case: FAIL
			throw new ItemNotFoundException(wordToFind + " not found.");
		} else if(wordToFind.compareTo(words[mid]) < 0) { 
			// Recursive Case: Check Left side, cut entire right half
			return recSearch(words, wordToFind, low, mid-1);
		} else if(wordToFind.compareTo(words[mid]) > 0) {
			// Recursive Case: Check right side, cut entire left half
			return recSearch(words, wordToFind, mid+1, high);
		}
		return -1;
	}
}
		
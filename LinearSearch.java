// Alan Lai
// 11/14/2019
// CSS 143
// BinarySearch Homework
/* LinearSearch.java searches for words in the word array one by one
 * by starting from index 0.
 * 
 * LinearSearch has a big O of (n).
 */
package binarySearch;

public class LinearSearch extends SearchAlgorithm {
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		// Linear Search: Looks through the whole array for the word. If not found, throw exception.
			int index = 0;
		while(getCount() <= words.length) {	// loops to search next index
			if(getCount()==words.length) { // base case: Fail
				throw new ItemNotFoundException(wordToFind + " not Found.");
			}
			else if(words[index].equals(wordToFind)) {
				incrementCount();
				return index;} // base case: Success
			else {
				incrementCount();
				index++;}} // increment for next loop
		return -1;
		}
	

	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		// A recursive Linear Search is extremely inefficient in terms of memory.
		// Recursive approach. Outer facade into an inner method.
		return recSearch(words, wordToFind, 0);
	}
	
	private int recSearch(String[] words, String wordToFind, int index) throws ItemNotFoundException {
		// Inner facade for recursive search.
		if(words[index].equals(wordToFind)) { // Base case: success
			incrementCount();
			return index;
		}
		else if(index==words.length) {	// Base case: Failure
			throw new ItemNotFoundException(wordToFind + " not found.");
		}
		else {	// Recursive Case.
			incrementCount();
			return recSearch(words, wordToFind, ++index);
		}
	}
	
}




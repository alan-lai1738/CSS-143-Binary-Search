// Alan Lai
// 11/14/2019
// CSS 143
// BinarySearch Homework
/* ItemNotFoundException.java is an exception we throw when a word isn't found.
 */
package binarySearch;

public class ItemNotFoundException extends RuntimeException{
	public ItemNotFoundException() {} // Empty Constructor (No message)
	
	public ItemNotFoundException(String msg) {	// Constructor with input error message
		System.out.println(msg);
	}
}

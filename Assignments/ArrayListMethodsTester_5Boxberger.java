import java.util.ArrayList;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class ArrayListMethodsTester_5Boxberger {
	public static void main( String[] args ) {
		int[] testData = {3, 6, 9, 2, 1, 9, 4, 7, 5};
		ArrayListMethods methods = new ArrayListMethods( testData );
		System.out.println("Swapping first and last elements:");
		methods.swapFirstAndLast( );
		methods.display( );
		System.out.println("Right shifting all elements:");
		methods.rightShift( ); // E7.10b
		methods.display( );
		System.out.println("Removing the middle element(s):");
		methods.removeMiddle( ); // E7.10e
		methods.display( );
		methods.display( );
		System.out.println("Second Largest Element: " + methods.secondLargest()); // E7.10g

		// These methods will return boolean (true or false)
		System.out.println("List is sorted in increasing order: " + methods.isIncreasing() );
		System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates() );
		System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates() );
		
	
		System.out.println("Move even values to front, otherwise preserving the ordering:");
		methods.moveEvens();  // E7.10f
		methods.display();
	}
 } // End class ArrayListMethodsTester
 
 class ArrayListMethods {
	private ArrayList<Integer> values;
	private int[] startingArray;
	
	/**Initializes the values list     @param data the integer array used to initialize the values list   */
	public ArrayListMethods( int[] data ) {
		values = new ArrayList<Integer>();
		startingArray = data;
		for( int i : startingArray ) values.add(i);
	}
	
	/**
		* Prints all of the elements in the ArrayList and then reset the ArrayList to its original state for testing
		*/
	public void display() { 
		System.out.println(values);
		reset();
	}

	/**
		* Change the ArrayList to its original state 
		*/
	private void reset() {
		values.clear();
		for(int i : startingArray) values.add(i);
	}
	
	public void swapFirstAndLast() {
		values.add(values.get(0));
		values.set(0, values.get(values.size()-2));
		values.remove(values.size()-2);
	}

	public void rightShift() {
		int originalLast = values.get(values.size()-1);
		for (int i = values.size() - 1; i > 0; i--) {
			values.set(i, values.get(i-1));
		}
		values.set(0, originalLast);

		//Alternative Solution:
		//values.add(0, values.get(values.size()-1));
		//values.remove(values.size()-1);
	}

	public void removeMiddle() {
		if(values.size()%2 == 1) {values.remove((values.size()-1)/2);}
		else {
			values.remove(values.size() / 2);
			values.remove((values.size()-1)/2);
		}
	}

	public void moveEvens() {
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i)%2 == 0) {
				int tempEven = values.get(i);
				values.remove(i);
				values.add(0, tempEven);
			}
		}
	}

	/**
	 * @return returns the largest int element of the ArrayList
	 */
	public int secondLargest() {
		int largest = values.get(0);
		for(int i = 0; i < values.size(); i++) {
			if (values.get(i) > largest) {
				largest = values.get(i);
			}
		}
			
		//make sure the second largest isnt equal to the largest, as this would break the algorythm
		int secondLargest = values.get(0);
		for (int num:values) {
			secondLargest = num;
			if (secondLargest != largest) break;
		}

		//run the loop again but ignore values equal to the smallest, which should return the second smallest
		for(int i = 0; i < values.size(); i++) {
			if (values.get(i) > secondLargest && values.get(i) != largest) {
				secondLargest = values.get(i);
			}
		}
		return secondLargest;
	}
	/**
	 * @return boolean that states if the list is in increasing order
	 */
	public boolean isIncreasing() {
		boolean increasing = false;
		for (int i = 0; i < values.size() - 1; i++) {
			if (values.get(i) <= values.get(i + 1)) {increasing = true;}
			else {
				increasing = false;
				break;
			}
		}
		return increasing;
	}
	/**
	 * @return boolean that staes if the list has two duplicates next to each other
	 */
	public boolean hasAdjacentDuplicates() {
		for(int i = 0; i < values.size() - 1; i++) {
			if(values.get(i) == values.get(i+1)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @return boolean that states if the list duplicates anywhere
	 */
	public boolean hasDuplicates() {
		for(int i = 0; i < values.size(); i++) {
			for(int j = 0; j < values.size(); j++) {
				if (values.get(i) == values.get(j)) {
					return true;
				}
			}
		}
		return false;
	}
}

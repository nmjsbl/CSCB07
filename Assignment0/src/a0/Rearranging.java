// **********************************************************
// Assignment0: Rearranging.java
// UTORID: sibalnao
// UT Student #: 1003939786
// Author: Naomi Joy Sibal
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check. 
// *********************************************************
package a0;

public class Rearranging {

	public static void rearranging(int[] items)
	{
		/* index that points to the last element of the array
		 * this will be on the positive side of the array (>0)
		 */
		int positiveCount = items.length-1;
		/* index that points to the first element of the array
		 * this will be on the negative side of the array (<0)
		 */
		int negativeCount = 0;

		while(negativeCount <= positiveCount){
			/* iterate the loop only while negativeCount <= positiveCount
			 * check the element at negativeCount starts from index 0
			 */
			
			if(items[negativeCount] < 0){
				// if element is negative
				// leave it as it is and increment negativeCount
				negativeCount++;
			}else if(items[negativeCount] > 0){
				// if element is positive
				// check 3 conditions
				if(items[positiveCount] < 0){
					// if element at positive side is negative
					// swap values with element at negativeCount
					swap(positiveCount, negativeCount, items);
					positiveCount--;
					negativeCount++;
				}else if(items[positiveCount] > 0){
					// if element at positive side is positive
					// leave it as it is and decrement positiveCount
					positiveCount--;
				}else{
					// if element is zero, swap values with element
					// negativeCount
					swap(positiveCount, negativeCount, items);
					positiveCount--;
				}
			}else if(items[negativeCount] == 0){
				// if element is zero
				// check 3 conditions
				if(items[positiveCount] < 0){
					// if element at positive side is negative
					// swap values with element at negativeCount
					swap(positiveCount, negativeCount, items);
					negativeCount++;
				}else if(items[positiveCount] > 0){
					// if element at positive side is positive
					// leave it as it is and decrement positiveCount
					positiveCount--;
				}else{
					// if element at positive side zero
					if(items[positiveCount-1] != 0){
						// check next element from the positive side
						// if not zero then swap
						swap(positiveCount, positiveCount-1, items);
					}else{
						// if next element from the positive side is zero
						negativeCount++;
						positiveCount--;
					}
				}
			}
			if(negativeCount+1 == positiveCount){
				// will break the while loop
				break;
			}
		}
		// check if zeros are in proper place
		if(items[positiveCount] == 0){
			if(items[positiveCount-1] > 0){
				swap(positiveCount, positiveCount-1, items);
			}
		}
		if(items[negativeCount] == 0){
			if(items[negativeCount+1] < 0){
				swap(negativeCount, negativeCount+1, items);
			}
		}
	}
	
	private static void swap(int i,int j,int[] items)
	{
		// a helper function that swaps the elements in items
		int swapVar = 0;
		swapVar = items[i];
		items[i] = items[j];
		items[j] = swapVar;
	}

	public static void main(String[] args) {
		/* You can modify the main function in any way you like.
		 * We will not mark your main function.  
		 */
		int [] items={-6, 5, 7, 0, 3, 4, 2, -1};
		/*
		 * printing the values in the items before 
		 * calling the method rearranging
		 */
		/*
		 *System.out.print("Unsorted Array: ");
		 *for(int item:items)
		 *{
		 *	System.out.print(item + " ");
		 *}
		 *System.out.print("\nSorted Array: ");
		 *
		 *if(items.length > 1) {
		 *	//calling the rearranging method
		 *	Rearranging.rearranging(items);
		 *}
		 */
		/*
		 * printing the values in the items after 
		 * calling the method rearranging
		 */
		/*for(int item:items)
		 *{
		 *	System.out.print(item + " ");
		 *}
		 */
	}
}
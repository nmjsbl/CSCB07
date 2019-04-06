// **********************************************************
// Assignment0:
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

package a3;

/**
 * This interface represents a matrix and has the relevant methods that
 * should be implemented in any matrix.
 */
public interface MatrixInterface<E> {
 
  public void populateMatrix(int index1, int index2, Number element);
  
  public Number[][] getMatrix();
}

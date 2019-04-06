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
 * Represents a Matrix the implements the MatrixInterface
 */
public abstract class Matrix<E> implements MatrixInterface<E>{
  
  /**
   * The number of users
   */
  protected int numberOfUser;
  
  /**
   * The two-dimensional matrix
   */
  protected Number matrix[][];
  
  /**
   * Constructor.
   */
  public Matrix(int numberOfUser) {
    this.numberOfUser = numberOfUser;
  }
  
  /**
   * Populates the matrix.
   * 
   * @param index1 acts as the x coordinate
   * @param index2 acts as the y coordinate
   * @param element is the element assigned at (index1, index2)
   */
  public void populateMatrix(int index1, int index2, Number element) {
    matrix[index1][index2] = element;
  }
  
  /**
   * Returns the matrix
   * 
   * @return matrix is the matrix
   */
  public Number[][] getMatrix() {
    return matrix;
  }
  
  /**
   * Returns the number of users
   * 
   * @return number of users
   */
  public int getNumberOfUser() {
    return this.numberOfUser;
  }
  
  /**
   * Gets the element at the given index
   * 
   * @param index1 acts as the x coordinate
   * @param index2 acts as the y coordinate
   * @return the element at index (index1, index2)
   */
  public Number getElement(int index1, int index2) {
    Number result;
    try {
     result = this.matrix[index1][index2];
     return result;
    } catch (NullPointerException e) {
      System.err.println("Error: Empty matrix.");
    }
    return null;
  }
}

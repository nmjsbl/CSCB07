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
 * Represents the UserMovie matrix that is a subclass of Matrix.
 */
public class UserMovieMatrix<E> extends Matrix<E>{
  
  /**
   * The number of movies
   */
  private int numberOfMovie;
   
  /**
   * Constructor
   * 
   * @param numberOfUser is the number of users
   * @param numberOfMovie is the number of movies
   */
  public UserMovieMatrix(int numberOfUser, int numberOfMovie) {
    super(numberOfUser);
    this.numberOfMovie = numberOfMovie;

    // instantiate the 2d matrix of size numberOfUsers*numberOfMovies
    matrix = new Number[numberOfUser][numberOfMovie];
  }
  
  /**
   * Gets the number of movies
   * 
   * @return the number of movies
   */
  public int getNumberOfMovie() {
    return this.numberOfMovie;
  }
}

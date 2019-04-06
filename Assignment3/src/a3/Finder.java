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

import java.util.ArrayList;

/**
 * Represents a finder
 */
public abstract class Finder implements FinderInterface {
  
  /**
   * The score founded
   */
  protected float score;
  
  /**
   * The lists of user pairs
   */
  protected ArrayList<String> userPairs;
  
  /**
   * Constructor
   */
  public Finder() {
    // instantiate the array list
    userPairs = new ArrayList<String>();
  }
  
  /**
   * The abstract method that finds the score from the UserUserMatrix
   * @param userUserMatrix is the instance of a Matrix
   */
  public abstract void findScore(Matrix userUserMatrix);
  
  /**
   * Gets the score
   * 
   * @return the score
   */
  public Number getScore(){
    return this.score;
  }
  
  /**
   * Gets the list of user pairs
   * 
   * @return the userPairs array list
   */
  public ArrayList<String> getUserPairs(){
    return this.userPairs;
  }
  
}
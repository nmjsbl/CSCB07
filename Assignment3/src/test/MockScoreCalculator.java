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

package test;

import a3.UserMovieMatrix;
import a3.UserUserMatrix;

public class MockScoreCalculator {

  public MockScoreCalculator() {
  }
  
  public UserUserMatrix
    calculateSimilarityScore(UserMovieMatrix userMovieMatrix) {
    
    /* Matrix looks like this:
     * 
     * 1.0000 0.1791 0.1464
     * 0.1791 1.0000 0.1791
     * 0.1464 0.1791 1.0000
     */
    
    // check userMovie matrix
    if(userMovieMatrix == null) {
      return null;
    }
    // instantiate and populate userUser matrix
    UserUserMatrix userUser = new UserUserMatrix(3);
    userUser.populateMatrix(0, 0, 1.0000);
    userUser.populateMatrix(0, 1, 0.1791);
    userUser.populateMatrix(0, 2, 0.1464);
    
    userUser.populateMatrix(1, 0, 0.1791);
    userUser.populateMatrix(1, 1, 1.0000);
    userUser.populateMatrix(1, 2, 0.1791);
    
    userUser.populateMatrix(2, 0, 0.1464);
    userUser.populateMatrix(2, 1, 0.1791);
    userUser.populateMatrix(2, 2, 1.0000);
    
    return userUser;
  }

}

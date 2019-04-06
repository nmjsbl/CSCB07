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
 * Represents a printer which prints the user user matrix and the pair of
 * users with their corresponding similarity and dissimilarity scores.
 *
 */
public class Printer {
  
  /**
   * Constructor.
   */
  public Printer() {
  }
  
  /**
   * Prints the pair of users with their corresponding
   * similarity and dissimilarity scores.
   * 
   * @param finder is the Finder object
   */
  public void printPairOfUsers(Finder finder) {
    String line1 = "";
    String line3 = "";
    String result = "";
    ArrayList<String> listOfUsers = finder.getUserPairs();
    
    if(finder instanceof SimilarFinder) {
      line1 += "\n\nThe most similar pairs of users"
          + " from above userUserMatrix are:\n";
      line3 += "with similarity score of " + String.format("%.4f", finder.getScore());
      
    } else {
      line1 += "\n\nThe most dissimilar pairs of users"
          + " from above userUserMatrix are:\n";
      line3 += "with dissimilarity score of " + String.format("%.4f", finder.getScore());
    }
    
    result = line1 + printUsers(listOfUsers) + line3;
    System.out.println(result);
  }
  
  /**
   * A helper function the prints the pair of users.
   * 
   * @param listOfUsers is the list of users
   * @return the string representation of the user pairs
   */
  private String printUsers(ArrayList<String> listOfUsers){
    
    String result = "";
    // printing the most dis/similar users
    for(int i = 0; i < listOfUsers.size(); i++) {
        // get all the user number in the dissimilarUser array
        String allUsers[] = listOfUsers.get(i).split(" ");
        result += "User" + allUsers[0] + " and User" + allUsers[1];
        // check if it's the last user pair to avoid printing extra comma
        if(i != listOfUsers.size()-1)
            result += ",\n";
        else
          result += "\n";
    }
    return result;
  }
  
  /**
   * Prints the UserUserMatrix
   * 
   * @param userUserMatrix is instance of the UserUserMatrix
   */
  public void printerMatrix(UserUserMatrix userUserMatrix) {
    
    // prints an extra line for formatting
    System.out.println("\n");
    
    // iterate through the userUserMatrix
    for(Object output: userUserMatrix) {
      System.out.print(output);
    }
  }
  
}

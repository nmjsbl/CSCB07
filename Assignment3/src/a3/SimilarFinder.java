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
 * Represents the Similar Finder that is a subclass of Finder
 */
public class SimilarFinder extends Finder {

  /**
   * Constructor
   * @param numberOfUser is the number of users
   */
  public SimilarFinder() {
    super();
  }
  
  /**
   * The overridden method from the Finder Interface which finds the
   * most similar pair of users and the score
   * 
   * @param userUserMatrix is the instance of a Matrix
   */
  @Override
  public void findScore(Matrix userUserMatrix) {
    try {
      // set the maximum value of similarity scores
      score = 0;
      
      int numberOfUser = userUserMatrix.getNumberOfUser();
      /* will only traverse the upper triangle of the matrix
       * since it is symmetric
       */
      for(int user1 = 0; user1 < numberOfUser; user1++) {
        for(int user2 = user1; user2 < numberOfUser; user2++) {
          // disregard the pair with itself
          if(user1 != user2) {
            // get the string representation of the user pairs
            String userPair =
                String.valueOf(user1+1) + ' ' + String.valueOf(user2+1);
            // get the user user score
            float userUserScore =
                userUserMatrix.getElement(user1, user2).floatValue();
            if(score < userUserScore) {
              /* if the userUser score is greater than the current score
              * then we'll remove all pairs in userPairs
              * and add the current userPair
              */ 
              userPairs.clear();
              userPairs.add(userPair);
              // replace the score with the current highest similarity score
              score = userUserScore;
                    
           } else if(score == userUserScore) {
              /* check if the current userUser score
               * is equal to the score then add the
               * current userPair to the userPairs array
               */
               userPairs.add(userPair);
           }
          }
        }
      }
    } catch (NullPointerException e) {
      System.err.println("Error: Empty UserUserMatrix.");
    }
  }
  
}

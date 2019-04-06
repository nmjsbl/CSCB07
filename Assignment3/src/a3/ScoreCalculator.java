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
 * Represents the ScoreCalculator the calculates the similarity score
 * @author naomi
 *
 */
public class ScoreCalculator implements ScoreCalculatorInterface {

  /**
   * Constructor
   */
  public ScoreCalculator() {
  }
  
  /**
   * Calculates the similarity score of the UserMovieMatrix
   * and instantiates and populate a UserUserMatrix
   * 
   * @param userMovieMatrix is the instance of the class UserMovieMatrix
   * @return the instance of the UserUserMatrix
   */
  public UserUserMatrix
    calculateSimilarityScore(UserMovieMatrix userMovieMatrix){
    // calculate the similarity scores and populate the userUserMatrix
    
    try {
      // initialize the number of users and number of movies
      int numberOfUsers = userMovieMatrix.getNumberOfUser();
      int numberOfMovies = userMovieMatrix.getNumberOfMovie();
      // instantiate UserUserMatrix
      UserUserMatrix userUserMatrix = new UserUserMatrix(numberOfUsers);
      
      // iterate through the users
      for(int user1 = 0; user1 < numberOfUsers; user1++) { 
          for (int user2 = 0; user2 < numberOfUsers; user2++) {
              
              // initialize needed variables
              double moviesTotal = 0;
              double distance = 0;
              double similarityScore = 0;
              
              // user helper function to get the total of movies
              moviesTotal =
                  this.calculateTotalMovies(user1, user2, userMovieMatrix);
              
              // get the distance by getting the square root
              distance = Math.sqrt(moviesTotal);
              // get the similarity score by using the formula
              // 1 / 1 + distance
              similarityScore = 1 / (1+distance);
              // populate userUserMatrix
              userUserMatrix.populateMatrix(user1, user2, similarityScore);
          }
      }
      return userUserMatrix;
    } catch (NullPointerException e) {
      System.err.println("Error: Empty UserMovie matrix.");
    }
    return null;
  }
  
  /**
   * A helper function that computes the total of all movies
   * 
   * @param user1 is the index of user1
   * @param user2 is the index of user2
   * @param userMovieMatrix is the instance of UserMovieMatrix
   * @return the total movies
   */
  private double calculateTotalMovies(int user1, int user2,
      UserMovieMatrix userMovieMatrix) {
    // initialize needed variables
    double moviesTotal = 0;
    for(int movie = 0; movie < userMovieMatrix.getNumberOfMovie(); movie++) {
      // initialize needed variables
      double movieDiff = 0;
      double movieSquared = 0;
      // get the difference of each movie rating from
      // user1 and user 2
      movieDiff = ((int) userMovieMatrix.getElement(user2, movie)
                   - (int) userMovieMatrix.getElement(user1, movie));
      // square their difference
      movieSquared = movieDiff * movieDiff;
      // add the squares of difference in the total movie rating
      moviesTotal += movieSquared;
    }
    
    return moviesTotal;
  }
}

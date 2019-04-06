// **********************************************************
// Assignment0: Cfiltering.java
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

import java.lang.Math;
import java.util.*;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*user
  private float userUserMatrix[][];
  
  // default constructor
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }

  // constructor with numberOfUsers, numberOfMovies parameters
  // that creates the 2d matrices
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
	  // this is 2d matrix of size numberOfUsers*numberOfMovies
	  userMovieMatrix = new int[numberOfUsers][numberOfMovies];
	  // this is 2d matrix of size numberOfUsers*numberOfUsers
	  userUserMatrix = new float[numberOfUsers][numberOfUsers];
  }

  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {
	  // populate the userMovieMatrix
    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }
  
  public void populateUserUserMatrix(int user1, int user2,
	      double similarityScore) {
	  /* A helper function that 
	   * populate the userUserMatrix with their similarity score
	   */
	    userUserMatrix[user1][user2] = (float) similarityScore;
	  }  

  public void calculateSimilarityScore(int numberOfUsers, int numberOfMovies){
	  // calculate the similarity scores and populate the userUserMatrix
	  
 	  // iterate through the users
	  for(int user1 = 0; user1 < numberOfUsers; user1++) { 
		  for (int user2 = 0; user2 < numberOfUsers; user2++) {
			  double moviesTotal = 0;
			  double distance = 0;
			  double similarityScore = 0;
			  
			  for(int movie = 0; movie < numberOfMovies; movie++) {
				  double movieDiff = 0;
				  double movieSquared = 0;
				  // get the difference of each movie rating from
				  // user1 and user 2
				  movieDiff = (userMovieMatrix[user2][movie]
						  		- userMovieMatrix[user1][movie]);
				  // square their difference
				  movieSquared = movieDiff * movieDiff;
				  // add the squares of difference in the total movie rating
				  moviesTotal += movieSquared;
			  }
			  // get the distance by getting the square root
			  distance = Math.sqrt(moviesTotal);
			  // get the similarity score by using the formula
			  // 1 / 1 + distance
			  similarityScore = 1 / (1+distance);
			  // use the help function to populate userUserMatrix
			  populateUserUserMatrix(user1, user2, similarityScore);
		  }
	  }
  }

  public void printUserUserMatrix(int numberOfUser) {
	  
	  // iterate through the users
	  for(int user1 = 0; user1 < numberOfUser; user1++) {
		  System.out.print("[");
		  for(int user2 = 0; user2 < numberOfUser; user2++) {
			  // get each similarity scores
			  float score = userUserMatrix[user1][user2];
			  // format score to 4 decimal places
			  System.out.print(String.format("%.4f", score));
			  if(user2 != numberOfUser-1) {
				  // check if it is the last user2 in each user 1
				  // print the comma if not
				  System.out.print(", ");
			  }
		  }
		  System.out.println("]");
	  }
  }

  public void findAndprintMostSimilarPairOfUsers(int numberOfUsers) {
	// for printing and finding the most similar pair of users
	  
	  // instantiate an array list of strings
	  ArrayList<String> similarUsers = new ArrayList<String>();
	  
	  System.out.println("The most similar pairs of users"
	  		+ " from above userUserMatrix are:");
	  
	  // this will hold the maximum value of similarity scores
	  float maxSimilar = 0;
	  
	  /* will only traverse the upper triangle of the matrix
	   * since it is symmetric
	   */
	  for(int user1 = 0; user1 < numberOfUsers; user1++) {
		  for(int user2 = user1; user2 < numberOfUsers; user2++) {
			  if(user1 != user2) {
				  // disregard the pair with itself
				  String userPair = String.valueOf(user1+1) + ' '
			  				+ String.valueOf(user2+1);
				  
				  if(maxSimilar < userUserMatrix[user1][user2]) {
					  /* if the userUser score is greater than the
					   * current maxSimilarity score
					   * then we'll remove all pairs in similarUsers
					   * and add the current userPair
					   */ 
					  similarUsers.clear();
					  similarUsers.add(userPair);
					  // replace the maxSimilar with the current
					  // highest similarity score
					  maxSimilar = userUserMatrix[user1][user2];
					  
				  } else if(maxSimilar == userUserMatrix[user1][user2]) {
					  /* check if the current userUser score
					   * is equal to the maxSimilar score then add the
					   * current userPair to the similarUsers array
					   */
					  similarUsers.add(userPair);
				  }
			  }
		  }
	  }
	  // printing the most similar users and their similarity scores
	  printUsers(similarUsers, maxSimilar);
  }

  public void findAndprintMostDissimilarPairOfUsers(int numberOfUsers) {
	  // for printing and finding the most dissimilar pair of users
	  
	  // instantiate an array list of strings
	  ArrayList<String> dissimilarUsers = new ArrayList<String>();
		  
	  System.out.println("The most dissimilar pairs of users"
			  + " from above userUserMatrix are:");
		  
	  // this will hold the minimum value of similarity scores
	  float minSimilar = 1;
		  
	  /* will only traverse the upper triangle of the matrix
	   * since it is symmetric
	   */
	  for(int user1 = 0; user1 < numberOfUsers; user1++) {
		  for(int user2 = user1; user2 < numberOfUsers; user2++) {
			  if(user1 != user2) {
				  // disregard the pair with itself
				  String userPair = String.valueOf(user1+1) + ' '
				  			+ String.valueOf(user2+1);
					  
				  if(minSimilar > userUserMatrix[user1][user2]) {
					  /* if the userUser score is less than the
					   * current minSimilar score
					   * then we'll remove all pairs in similarUsers
					   * and add the current userPair
					   */ 
					  dissimilarUsers.clear();
					  dissimilarUsers.add(userPair);
					  // replace the minSimilar with the current
					  // lowest similarity score
					  minSimilar = userUserMatrix[user1][user2];
						  
				  } else if(minSimilar == userUserMatrix[user1][user2]) {
					  /* check if the current userUser score
					   * is equal to the minSimilar score then add the
					   * current userPair to the dissimilarUsers array
					   */
					  dissimilarUsers.add(userPair);
				  }
			  }
		  }
	  }
	  // printing the most similar users and their similarity scores
	  printUsers(dissimilarUsers, minSimilar);
  }

  public void printUsers(ArrayList<String> listOfUsers, float similarityScore){
	// helper function that prints the pair of users
	  
	// printing the most dis/similar users
	for(int i = 0; i < listOfUsers.size(); i++) {
		// get all the user number in the dissimilarUser array
		String allUsers[] = listOfUsers.get(i).split(" ");
		System.out.print("User" + allUsers[0] + " and User" + allUsers[1]);
		// check if it's the last user pair to avoid printing extra comma
		if(i != listOfUsers.size()-1) {
			System.out.println(",");
		}else {
			System.out.println();
		}
	}
	System.out.println("with similarity score of " +
			String.format("%.4f", similarityScore));
  }
  
}

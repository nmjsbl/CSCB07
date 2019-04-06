// **********************************************************
// Assignment0: CfilteringDriver.java
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
package driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import a0.Cfiltering;

public class CfilteringDriver {

  public static void main(String[] args) {
    try {
      // open file to read
      String fileName;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of input file? ");
      fileName = in.nextLine();
      FileInputStream fStream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());
      
      /* instantiate Cfiltering object that contains
      * a 2d matrix of size numberOfUsers * numberOfMovies
      * and a 2d matrix of size numberOfUsers*numberOfUsers
      */
      Cfiltering cfObject = new Cfiltering(numberOfUsers, numberOfMovies);

      // this is a blankline being read
      br.readLine();

      // read each line of movie ratings and populate the
      // userMovieMatrix
      String row;
      
      int userNumber = 0;

      while ((row = br.readLine()) != null) {
        // allRatings is a list of all String numbers on one row
        String allRatings[] = row.split(" ");
        int movieNumber = 0;
        for (String singleRating : allRatings) {
        	// make the parse string to an integer
        	int rate = Integer.parseInt(singleRating);
        	// populate userMovieMatrix
        	cfObject.populateUserMovieMatrix(userNumber, movieNumber, rate);
        	movieNumber++;
        }
        userNumber++;
      }
      // close the file
      fStream.close();
      
      // print extra new line
      System.out.println("\n");
      // calculate the similarity score between users
      cfObject.calculateSimilarityScore(numberOfUsers, numberOfMovies);
      
      // print the userUserMatrix
      cfObject.printUserUserMatrix(numberOfUsers);
      
      // print extra new line
      System.out.println("\n");
      // find and print most similar user pairs
      cfObject.findAndprintMostSimilarPairOfUsers(numberOfUsers);
      
      // print extra new line
      System.out.println("\n");
      // find and print most dissimilar user pairs
      cfObject. findAndprintMostDissimilarPairOfUsers(numberOfUsers);
      
    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root folder "
          + "of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    }
  }
}

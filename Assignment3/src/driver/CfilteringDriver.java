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

package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import a3.DissimilarFinder;
import a3.FileReader;
import a3.Printer;
import a3.ScoreCalculator;
import a3.SimilarFinder;
import a3.UserMovieMatrix;
import a3.UserUserMatrix;

public class CfilteringDriver {

  /**
   * Reads user movie ratings from a text file, calculates similarity scores and
   * prints a score matrix.
   */
  public static void main(String[] args) {
    
    // instantiate file reader
    FileReader fileReader = new FileReader();

    // get the file to read
    File file = fileReader.getFileToRead();
    
    // read the file given by the user and instantiate the UserMovieMatrix
    UserMovieMatrix userMovieMatrix = fileReader.readFile(file);
    
    // check if the given file is valid
    try {
      // instantiate ScoreCalculator that calculates the similarity score
      ScoreCalculator scoreCalculator = new ScoreCalculator();
      
      // instantiate the UserUserMatrix by calculating the similarity score
      // of the UserMovieMatrix
      UserUserMatrix userUserMatrix =
          scoreCalculator.calculateSimilarityScore(userMovieMatrix);
      
      // instantiate SimilarFinder
      SimilarFinder similarFinder = new SimilarFinder();
      
      // instantiate DissimilarFinder
      DissimilarFinder dissimilarFinder = new DissimilarFinder();
      
      // find the similar scores
      similarFinder.findScore(userUserMatrix);
      
      // find the dissimilar scores
      dissimilarFinder.findScore(userUserMatrix);
      
      // instantiate printer
      Printer printer = new Printer();
      
      // print the UserUserMatrix
      printer.printerMatrix(userUserMatrix);
      
      // print the pair of users that have similar scores
      printer.printPairOfUsers(similarFinder);
      
      // print the pair of users that have dissimilar scores
      printer.printPairOfUsers(dissimilarFinder);
      
    } catch(NullPointerException e) {
      System.err.println("Error: Invalid file to filter.");
    }
  }

}

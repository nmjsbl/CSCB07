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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Represents the FileReader which reads the file given by the user
 *
 */
public class FileReader implements FileReaderInterface {
  
  /**
   * Constructor
   */
  public FileReader() {
  }
  
  /**
   * Reads the file given by the user, instantiate a UserMovieMatrix
   * 
   * @param file is the File object
   * @return the object that the UserMovieMatrix represents
   */
  public UserMovieMatrix readFile(File file) { 
    
    try {
      FileInputStream fStream = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

      // Read dimensions: number of users and number of movies
      int numberOfUsers = Integer.parseInt(br.readLine());
      int numberOfMovies = Integer.parseInt(br.readLine());
      
      /* instantiate UserMovieMatrix object that contains
      * a 2d matrix of size numberOfUsers * numberOfMovies
      */
     UserMovieMatrix userMovieMatrix =
         new UserMovieMatrix(numberOfUsers, numberOfMovies);

      // this is a blankline being read
      br.readLine();

      // read each line of movie ratings and populate the
      // userMovieMatrix
      String row;
      
      // initialize userNumber
      int userNumber = 0;

      while ((row = br.readLine()) != null) {
        // allRatings is a list of all String numbers on one row
        String allRatings[] = row.split(" ");
        int movieNumber = 0;
        
        for (String singleRating : allRatings) {
            // make the parsed string to an integer
            int rate = Integer.parseInt(singleRating);
            // populate userMovieMatrix
            userMovieMatrix.populateMatrix(userNumber, movieNumber, rate);
            movieNumber++;
        }
        userNumber++;
      }
      // close the file;
      fStream.close();
      return userMovieMatrix;
    } catch (FileNotFoundException e) {
      System.err.println("Error: No such file or directory.");
    } catch (IOException e) {
      System.err.print(e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("Error: The input string is not an integer.");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Error: Invalid inputs from file.");
    }
    return null;
  }
  
  /**
   * Gets the file to be read
   * 
   * @return the file that needs to be read
   */
  public File getFileToRead() {
    // open file to read
    String fileName;
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name of input file? ");
    fileName = in.nextLine();
    File file = new File(fileName);
    
    return file;
  }
}

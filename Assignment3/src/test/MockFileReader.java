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

import java.io.File;
import a3.UserMovieMatrix;
import a3.FileReaderInterface;


public class MockFileReader implements FileReaderInterface {
  
  public MockFileReader() {
  }
  
  public UserMovieMatrix readFile(File file) { 
      
    /* File looks like this:
       *    3
       *    6
       *    
       *    1 2 3 4 5 1
       *    2 3 4 5 1 2
       *    3 4 5 1 2 3
       */
    
    // check file
    if(file == null) {
      return null;
    }
    // number of users and number of movies
    int numberOfUsers = 3;
    int numberOfMovies = 6;
    
    /* instantiate UserMovieMatrix object that contains
    * a 2d matrix of size numberOfUsers * numberOfMovies
    */
    UserMovieMatrix userMovieMatrix =
       new UserMovieMatrix(numberOfUsers, numberOfMovies);

    // initialize array values and populate the
    // userMovieMatrix
    int[] row1 = {1, 2, 3, 4, 5, 1};
    int[] row2 = {2, 3, 4, 5, 1, 2};
    int[] row3 = {3, 4, 5, 1, 2, 3};
    
    for(int i=0; i<row1.length; i++)
      userMovieMatrix.populateMatrix(0, i, row1[i]);
    
    for(int i=0; i<row1.length; i++)
      userMovieMatrix.populateMatrix(1, i, row2[i]);
   
    for(int i=0; i<row1.length; i++)
      userMovieMatrix.populateMatrix(2, i, row3[i]);
    
    return userMovieMatrix;
  }
  
  public File getFileToRead() {
    String fileName = "test3.txt";
    File file = new File(fileName);
    return file;
  }
}

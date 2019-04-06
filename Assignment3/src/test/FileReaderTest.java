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

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import a3.UserMovieMatrix;

public class FileReaderTest {

  // for setting up objects
  MockFileReader fileReader;
  UserMovieMatrix userMovieMatrix;
  // used for fil reading
  File file1;
  File file2;
  // initialize integer values
  int numberOfUsers = 3;
  int numberOfMovies = 6;
  
  
  @Before
  public void setUp() {
    // initialize objects
    fileReader = new MockFileReader();
    file1 = new File("src/test/test3.txt");
  }
  
  @Test
  public void testGetFileToRead1() {
    File actual = fileReader.getFileToRead();
    assertNotNull(actual);
  }
  
  @Test
  public void testReadFile1() {
    userMovieMatrix = fileReader.readFile(file1);
    assertNotNull(userMovieMatrix);
  }
  
  @Test
  public void testReadFile2() {
    userMovieMatrix = fileReader.readFile(file1);
    int actual = userMovieMatrix.getNumberOfMovie();
    assertEquals(numberOfMovies, actual);
  }
  
  @Test
  public void testReadFile3() {
    userMovieMatrix = fileReader.readFile(file1);
    int actual = userMovieMatrix.getNumberOfMovie();
    assertEquals(numberOfMovies, actual);
  }
  
  @Test
  public void testReadFile4() {
    userMovieMatrix = fileReader.readFile(file2);
    assertNull(userMovieMatrix);
  }

}

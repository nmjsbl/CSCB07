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
import org.junit.Test;
import a3.UserMovieMatrix;
import org.junit.Before;

public class UserMovieMatrixTest {
  
  // for setting up objects
  UserMovieMatrix userMovie1;
  UserMovieMatrix userMovie2;
  File file;
  MockFileReader fileReader;
  // initialize integer values
  int numberOfUser = 3;
  int numberOfMovie = 6;
  
  @Before
  public void setUp() {
    // instantiate objects
    file = new File("src/test/test3.txt");
    fileReader = new MockFileReader();
    userMovie1 = new UserMovieMatrix(numberOfUser, numberOfMovie);
    // set up userMovie Matrix
    userMovie2 = fileReader.readFile(file);
  }
  
  @Test
  public void testGetNumberOfUser() {
    int actual = userMovie1.getNumberOfUser();
    assertEquals(numberOfUser, actual);
  }
  
  @Test
  public void testGetNumberOfMovie() {
    int actual = userMovie1.getNumberOfMovie();
    assertEquals(numberOfMovie, actual);
  }
  
  @Test
  public void testPopulateMatrix1() {
    userMovie1.populateMatrix(0, 4, 6);
    Number[][] matrix = userMovie1.getMatrix();
    int actual = (int) matrix[0][4];
    assertEquals(6, actual);
  }
  
  @Test
  public void testPopulateMatrix2() {
    userMovie1.populateMatrix(1, 2, 1);
    Number[][] matrix = userMovie1.getMatrix();
    int actual = (int) matrix[1][2];
    assertEquals(1, actual);
  }
  
  @Test
  public void testGetMatrix1() {
    Number[][] matrix = userMovie1.getMatrix();
    int actual = matrix.length;
    assertEquals(numberOfUser, actual);
  }
  
  @Test
  public void testGetMatrix2() {
    Number[][] matrix = userMovie1.getMatrix();
    int actual = matrix[0].length;
    assertEquals(numberOfMovie, actual);
  }
  
  @Test
  public void testGetElement1() {
    Object actual = userMovie1.getElement(2, 2);
    assertNull(actual);
  }
  
  @Test
  public void testGetElement2() {
    int actual = (int) userMovie2.getElement(0,0);
    assertEquals(1, actual);
  }
  
  @Test
  public void testGetElement3() {
    int actual = (int) userMovie2.getElement(0,1);
    assertEquals(2, actual);
  }
  
  @Test
  public void testGetElement4() {
    int actual = (int) userMovie2.getElement(0,3);
    assertEquals(4, actual);
  }
  
  @Test
  public void testGetElement5() {
    int actual = (int) userMovie2.getElement(1,4);
    assertEquals(1, actual);
  }
  
  @Test
  public void testGetElement6() {
    int actual = (int) userMovie2.getElement(1,2);
    assertEquals(4, actual);
  }
  
  @Test
  public void testGetElement7() {
    int actual = (int) userMovie2.getElement(2,3);
    assertEquals(1, actual);
  }
  
  @Test
  public void testGetElement8() {
    int actual = (int) userMovie2.getElement(2,0);
    assertEquals(3, actual);
  }
  
  @Test
  public void testGetElement9() {
    int actual = (int) userMovie2.getElement(1,1);
    assertEquals(3, actual);
  }

}

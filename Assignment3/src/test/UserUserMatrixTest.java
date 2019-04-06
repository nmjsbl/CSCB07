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
import a3.UserUserMatrix;

public class UserUserMatrixTest {
  
  // for setting up objects
  UserUserMatrix userUser1;
  UserUserMatrix userUser2;
  UserMovieMatrix userMovie;
  File file;
  MockFileReader fileReader;
  MockScoreCalculator scoreCalc;
  // initialize integer
  int numberOfUser = 3;
  
  String expectedIterator = "[1.0000, 0.1791, 0.1464]\n" + 
      "[0.1791, 1.0000, 0.1791]\n" + 
      "[0.1464, 0.1791, 1.0000]\n";
  
  @Before
  public void setUp() {
    // instantiate objects
    file = new File("src/test/test3.txt");
    fileReader = new MockFileReader();
    userUser1 = new UserUserMatrix(numberOfUser);
    userMovie = fileReader.readFile(file);
    scoreCalc = new MockScoreCalculator();
    // calculate similarity score matrix
    userUser2 = scoreCalc.calculateSimilarityScore(userMovie);
  }
  
  @Test
  public void testGetNumberOfUser() {
    int actual = userUser1.getNumberOfUser();
    assertEquals(numberOfUser, actual);
  }

  @Test
  public void testPopulateMatrix1() {
    userUser1.populateMatrix(0, 0, 1);
    userUser1.populateMatrix(0, 1, 2);
    userUser1.populateMatrix(0, 2, 3);
    Number[][] matrix = userUser1.getMatrix();
    int actual = (int) matrix[0][2];
    assertEquals(3, actual);
  }
  
  @Test
  public void testPopulateMatrix2() {
    userUser1.populateMatrix(1, 0, 2);
    userUser1.populateMatrix(1, 1, 3);
    userUser1.populateMatrix(1, 2, 4);
    Number[][] matrix = userUser1.getMatrix();
    int actual = (int) matrix[1][2];
    assertEquals(4, actual);
  }
  
  @Test
  public void testGetMatrix1() {
    Number[][] matrix = userUser1.getMatrix();
    int actual = matrix.length;
    assertEquals(numberOfUser, actual);
  }
  
  @Test
  public void testGetMatrix2() {
    Number[][] matrix = userUser1.getMatrix();
    int actual = matrix[0].length;
    assertEquals(numberOfUser, actual);
  }
  
  @Test
  public void testGetElement1() {
    Object actual = userUser1.getElement(1,2);
    assertNull(actual);
  }
  
  @Test
  public void testGetElement2() {
    userUser1.populateMatrix(0, 0, 1);
    int actual = (int) userUser1.getElement(0,0);
    assertEquals(1, actual);
  }
  
  @Test
  public void testGetElement3() {
    float expected = (float) 1.000;
    float actual = userUser2.getElement(0,0).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement4() {
    float expected = (float) 0.1791;
    float actual = userUser2.getElement(0,1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement5() {
    float expected = (float) 0.1791;
    float actual = userUser2.getElement(0,1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement6() {
    float expected = (float) 0.1464;
    float actual = userUser2.getElement(0,2).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement7() {
    float expected = (float) 0.1791;
    float actual = userUser2.getElement(1,0).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement8() {
    float expected = (float) 1.000;
    float actual = userUser2.getElement(1,1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement9() {
    float expected = (float) 0.1791;
    float actual = userUser2.getElement(1,2).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement10() {
    float expected = (float) 0.1464;
    float actual = userUser2.getElement(2,0).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement11() {
    float expected = (float) 0.1791;
    float actual = userUser2.getElement(2,1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetElement12() {
    float expected = (float) 1.000;
    float actual = userUser2.getElement(2,2).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testIterator1() {
    String actual = "";
    for(Object result: userUser2)
      actual += (String) result;
    
    assertEquals(expectedIterator, actual);
  }

}

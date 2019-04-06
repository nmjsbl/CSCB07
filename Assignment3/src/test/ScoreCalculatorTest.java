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

public class ScoreCalculatorTest {
  
  // for setting up objects
  MockScoreCalculator scoreCalc;
  MockFileReader fileReader;
  UserUserMatrix userUser;
  UserMovieMatrix userMovie;
  File file;
  
  @Before
  public void setUp() {
    // instantiate objects
    scoreCalc = new MockScoreCalculator();
    fileReader = new MockFileReader();
    file = new File("src/test/test3.txt");
  }
  
  @Test
  public void testCalculateSimilarityScore1() {
    userMovie = fileReader.readFile(null);
    userUser = scoreCalc.calculateSimilarityScore(userMovie);
    assertNull(userUser);
  }
  
  @Test
  public void testCalculateSimilarityScore2() {
    userMovie = fileReader.readFile(file);
    userUser = scoreCalc.calculateSimilarityScore(userMovie);
    assertNotNull(userUser);
  }
  
  @Test
  public void testCalculateSimilarityScore3() {
    userMovie = fileReader.readFile(file);
    userUser = scoreCalc.calculateSimilarityScore(userMovie);
    float expected = (float) 0.1791;
    float actual = userUser.getElement(0, 1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testCalculateSimilarityScore4() {
    userMovie = fileReader.readFile(file);
    userUser = scoreCalc.calculateSimilarityScore(userMovie);
    float expected = (float) 1.000;
    float actual = userUser.getElement(1, 1).floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testCalculateSimilarityScore5() {
    userMovie = fileReader.readFile(file);
    userUser = scoreCalc.calculateSimilarityScore(userMovie);
    float expected = (float) 0.1464;
    float actual = userUser.getElement(2, 0).floatValue();
    assertEquals(expected, actual, 0.0f);
  }

}

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
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import a3.DissimilarFinder;
import a3.UserMovieMatrix;
import a3.UserUserMatrix;

public class DissimilarFinderTest {

  // for setting up objects
  DissimilarFinder dissimilarFinder;
  MockScoreCalculator scoreCalculator;
  UserUserMatrix userUser;
  
  @Before
  public void setUp() {
    // instantiate objects
    dissimilarFinder = new DissimilarFinder();
    scoreCalculator = new MockScoreCalculator(); 
    // instantiate userUser matrix
    userUser =
        scoreCalculator.calculateSimilarityScore(new UserMovieMatrix(3,3));
    // get the dissimilar score
    dissimilarFinder.findScore(userUser);
  }
  
  @Test
  public void testGetScore() {
    float expected = (float) 0.1464;
    float actual = dissimilarFinder.getScore().floatValue();
    assertEquals(expected, actual, 0.0f);
  }
  
  @Test
  public void testGetUserPair1() {
    ArrayList<String> expectedList = dissimilarFinder.getUserPairs();
    int expected = expectedList.size();
    int actual = 1;
    assertEquals(expected, actual);
  }
  
  @Test
  public void testGetUserPair2() {
    ArrayList<String> expectedList = dissimilarFinder.getUserPairs();
    String expected = expectedList.get(0);
    String actual = "1 3";
    assertEquals(expected, actual);
  }
  
}

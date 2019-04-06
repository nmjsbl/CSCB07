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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Represents the UserUser matrix that is a subclass of Matrix
 * and implements Iterable.
 */
public class UserUserMatrix<E> extends Matrix<E> implements Iterable<E>{
  
  /**
   * Constructor
   * 
   * @param numberOfUser is the number of users
   */
  public UserUserMatrix(int numberOfUser) {
    super(numberOfUser);
    // this is 2d matrix of size numberOfUsers*numberOfUsers
    matrix = new Number[numberOfUser][numberOfUser];
  }
  
  /**
   * Represents the UserUserMatrixIterator which implements the Iterator.
   */
  public class UserUserMatrixIterator<E> implements Iterator<E>{
    
    Queue<ArrayList<E>> queue;
    
    /**
     * Constructor of UserUserMatrixIterator
     * @param matrix is the 2d matrix of size user*user
     */
    public UserUserMatrixIterator(Number[][] matrix) {
        // instantiate queue object
        queue = new LinkedList<>();
        
        // iterate through the users
        for(int user1 = 0; user1 < numberOfUser; user1++) {
          ArrayList<E> userUserArray = new ArrayList<E>();
            for(int user2 = 0; user2 < numberOfUser; user2++) {
              // get each similarity scores in the ArrayList
                userUserArray.add((E)matrix[user1][user2]);
            }
            // enqueue the array list in the queue
            queue.add(userUserArray); 
        }
    }
    
    /**
     * The overridden method from the Iterator Interface that checks if the
     * queue is empty or not.
     * 
     * @return the corresponding boolean value
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return !(queue.isEmpty());
    }

    /**
     * The overridden method from the Iterator Interface that checks if there
     * is a next element in the queue.
     * 
     * @return the string representation of the UserUserMatrix
     */
    @Override
    public E next() {
        // TODO Auto-generated method stub
        if (hasNext()) {
            ArrayList<E> userUserArray = queue.poll();
            String result = "[";
            for(int i = 0; i < userUserArray.size(); i++) {
              result += String.format ("%,.4f", userUserArray.get(i));
              if(i != userUserArray.size()-1)
              result += ", " ;
            }
             result += "]\n";
             
            return (E) result;
        }
        return null;
    } 
  }
  
  /**
   * The overridden method from the Iterable Interface that instantiate a
   * UserUserMatrixIterator object.
   * 
   * @return an Iterator object
   */
  @Override
  public Iterator<E> iterator() {
      // TODO Auto-generated method stub
      return new UserUserMatrixIterator<>(matrix);
  }
}

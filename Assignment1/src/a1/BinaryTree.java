package a1;
import java.util.ArrayList;
import java.util.LinkedList;
// **********************************************************
// Assignment1:
// Student1:
// UTORID user_name: sibalnao
// UT Student #: 1003939786
// Author: Naomi Joy Sibal
//
// Student2:
// UTORID user_name: tarannu7
// UT Student #: 1003940471
// Author: Tahasun Tarannum
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************

/*
 * the provided starter code may contain warnings of raw type. 
 * This is OK, because we have'nt yet learned generics. After having
 * learnt generics, we will revisit this code, and remove the warnings out. 
 */
public class BinaryTree {

	private Node root;

	/* DO NOT MODIFY THIS METHOD
	 * WE HAVE ALREADY COMPLETED THIS METHOD
	 * FOR YOU.
	 * adds data inside a binary
	 * tree level by level starting
	 * from left to right. 
	 */
	public void addData(int d) {
		Node toAdd=new Node(d);
		if (root==null) {
			root=toAdd;
		} else {
			LinkedList ll=new LinkedList();
			ll.add(root);
			while(!(ll.isEmpty())) {
				Node currentNode=(Node)ll.poll();
				if (currentNode.getLeftNode()==null) {
					currentNode.setLeftNode(toAdd);
					break;
				} else if (currentNode.getRightNode()==null) {
					currentNode.setRightNode(toAdd);
					break;
				} else {
					/*
					 * remember, the queue is FIFO, and due to this
					 * we add first the left node followed by the right
					 * node.
					 */
					ll.add(currentNode.getLeftNode());
					ll.add(currentNode.getRightNode());
				}
			}
		}
	}
	

	public String toString() {
	  // initialize an empty string
	  // this contain the string the will be returned
	  String result = "";

	  LinkedList ll = new LinkedList();
	  
	  if(root==null) {
	    // the binary tree is empty
	    return result;
	  }
	  
	  // if the binary tree is not empty
	  // we add the root of the binary tree to the linked list
	  ll.addLast(root);
	  
	  // a local variable that will hold the current node
	  // as we traverse the binary tree
	  Node currentNode = new Node();
	  
	  // loop iterates while the linked list is not empty
	  while (!(ll.isEmpty())) {
	    // pops the node in the linked list
	    currentNode = (Node) ll.poll();
	    // concatenate result with the current data of currentNode
	    result += currentNode.toString() + " ";
	    // get the left and right node of the current node
	    Node left = currentNode.getLeftNode();
	    Node right = currentNode.getRightNode();
	    
	    // if left node is not null, we append this on the linked list
	    if (left != null) {
	      ll.addLast(left);
	    }
	    // if right node is not null, we append this on the linked list
	    if (right != null) {
	      ll.addLast(right);
	    }
	  }
	  // the resulting string is trimmed to remove extra white spaces
	  return result.trim();
	}
	

	public ArrayList toList() {
		// instantiate a new array list object
		ArrayList inorder = new ArrayList();
		
		// call recursive function that will populate the inorder array list
		addSubTree(root, inorder);
		
		// return the array list in an inorder manner
		return inorder;
	}
	

	private void addSubTree(Node temp, ArrayList values) {
		// check if we reached the last node in the binary tree
		// so the inorder traversal can proceed
		if(temp != null) {
			// Inorder Traversal
			// Left Node
			addSubTree(temp.getLeftNode(), values);
			// Root Node
			values.add(temp.getData());
			// Right Node
			addSubTree(temp.getRightNode(), values);
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		/*
		 * adding the following ints in a binary tree. Remember, the addData
		 * adds the ints level by level and from left to right. I will first 
		 * ask you to run the starter code and debug out the addData so that 
		 * you are familiar with how it works and trace the creation of the 
		 * tree using pen and paper. 
		 */
		bt.addData(1);
		bt.addData(2);
		bt.addData(3);
		bt.addData(4);
		bt.addData(5);
		bt.addData(6);
		bt.addData(7);
		
		System.out.println(bt); //must print 1 2 3 4 5 6 7 
		
		/*
		 * Printing the list of the binary
		 * tree. Remember the list of the binary
		 * tree must contain the ints in inOrder
		 * traversal. The for loop below will 
         * give you back a null pointer exception
         * when trying to run the starer code,
         * this is because toList() method inside
         * the BinaryTree returns back a null.
		 */
		for (Object d:bt.toList()) {
			System.out.println((int)d);
		}
	}
}

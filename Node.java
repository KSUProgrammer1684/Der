package parser;
/**This class creates a tree to store the tokens. 
 * 
 * @author Brian Baker
 *
 */
public class Node {
	String token;
	Node right;
	Node left;
	
	/**This is a constructor for Node. The right and left nodes are empty. 
	 * Token is set to value given in parameter.
	 * 
	 * @param token
	 */
	public Node(String token) {
		this.token = token; 
		this.right = null;
		this.left = null; 
	}
	/**This method creates left and right nodes if there are none.
	 * Otherwise, left and right nodes will be assigned a value.   
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @param token
	 */
	public void insertToken(String token) {
		if(this.left == null) {
			this.left = new Node(token);
		}
		
		if(this.right == null) {
			this.right = new Node(token);
		} 
		if(this.right != null && this.left != null) {
			if(howManyNodes(this.left) <= howManyNodes(this.right)) {
				//this.left.insertToken(token);
				this.left.token = token;
			} else {
				//this.right.insertToken(token);
				this.right.token = token; 
			}	
		}
	}
	/**This method finds how many nodes are in a tree. 
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @param node
	 * @return howManyNodes
	 */
	public int howManyNodes(Node node) {
		int howmanynodes = 1; 
		if(node == null) {
			return 0;
		}
		
		howmanynodes += howManyNodes(node.left);
		howmanynodes += howManyNodes(node.right);
		
		return howmanynodes;
	}
	/**This is the tree class. Here the root is stored. Here is where you traverse the tree as well. 
	 * 
	 * @author Brian Baker
	 *
	 */
class Tree {
	Node root;
	
	/**This is a constructor sets the root equal to null. 
	 * 
	 */
	public Tree() {
		this.root = null; 
	}
	
	/**This method determines if the tree is empty or not. 
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @return True or False
	 */
	public boolean emptyTree() {
		if(this.root == null) {
			return true; 
		}
		return false; 
	}
	
	/**This method adds a root node to the tree. 
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @param token
	 */
	public void addRoot(String token) {
		if(this.root == null) {
			this.root = new Node(token);
		}
	}
	
	/**Traverse using pre-oder from top to bottom of tree.
	 * @precondition: none
	 * @postcondition: none 
	 * @param node
	 * @return preorder traversal
	 */
	public String traverse(Node node) {
		String preorder;
		if(node == null) {
			return "";
		}
		preorder = "" + node.token;
		traverse(node.left);
		traverse(node.right);
			
		return preorder; 
		
	}
}
}
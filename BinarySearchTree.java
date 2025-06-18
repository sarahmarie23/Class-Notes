public class BinarySearchTree {
	// Consider moving Node to a separate class
	// Keeping it an inner class for simplicity
    private class Node {
		int val;
    	Node left; 
		Node right;
		
        Node(int val) {
			this.val = val;
        }
    }
	
	private Node root;

	public BinarySearchTree() {
		root = null;
	}
	
	// TODO: Add a new Node
	public void add(int val) {
    	root = addRecursive(root, val);
        //addRecursive(root, val); do this as a mistake
	}

	private Node addRecursive(Node current, int val) {
		// Base case: No child Nodes exist
		if (current == null) {
			return new Node(val);
		}

		// Recursive case: check if the value is lower or higher and recurse
		if (val < current.val) {
			current.left = addRecursive(current.left, val);
		} else if (val > current.val) {
			current.right = addRecursive(current.right, val);
		}

		// Note: Our tree does not accept duplicate values

		return current;
	}

	// Utility methods
    public void printTree() {
		printTreeRecursive(root);
		System.out.println();
    }

	private void printTreeRecursive(Node node) {
		if (node != null) {
			printTreeRecursive(node.left);
			System.out.print(node.val + " ");
			printTreeRecursive(node.right);
		}
	}
}

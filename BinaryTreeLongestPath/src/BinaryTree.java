
public class BinaryTree {
	Node root;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		//tree.root = new Node(6);
		//tree.insertNode(new Node(6));
		tree.root = tree.insertNodeRecursive(new Node(6), tree.root);
		
		//tree.root.left = new Node(3);
		//tree.insertNode(new Node(3));
		tree.insertNodeRecursive(new Node(3), tree.root);

		//tree.root.right = new Node(12);
		//tree.insertNode(new Node(12));
		tree.insertNodeRecursive(new Node(12), tree.root);

		//tree.root.left.left = new Node(2);
		//tree.insertNode(new Node(2));
		tree.insertNodeRecursive(new Node(2), tree.root);

		//tree.root.left.right = new Node(4);
		//tree.insertNode(new Node(4));
		tree.insertNodeRecursive(new Node(4), tree.root);

		//tree.root.right.left = new Node(8);
		//tree.insertNode(new Node(8));
		tree.insertNodeRecursive(new Node(8), tree.root);

		//tree.root.right.right = new Node(14);
		//tree.insertNode(new Node(14));
		tree.insertNodeRecursive(new Node(14), tree.root);

		//tree.root.right.right.right = new Node(16);
		//tree.insertNode(new Node(16));
		tree.insertNodeRecursive(new Node(16), tree.root);

		tree.printInorder();
		System.out.println("tree.height() = " + tree.height());
		System.out.println("tree.diameter() = " + tree.diameter());
	}

	void insertNodeIterative(Node node) {
		
		Node parentNode = null;
		
		if (node == null)
			return;
		
		if (root == null) {
			root = node;
			return;
		}
		
		parentNode = root;
		
		while (true){
			if (node.data <= parentNode.data) {
				if (parentNode.left == null) {
					parentNode.left = node;
				break;
				}
				else
				parentNode = parentNode.left;
			}				
			
			else
				if (parentNode.right == null) {
					parentNode.right = node;
					break;
				}
				else
				parentNode = parentNode.right;			
		}		
	}
	
	Node insertNodeRecursive(Node node, Node root) {
		if (root == null) {
			root = node;
			return root;
		}
		
		if (node.data <= root.data) {
			root.left = insertNodeRecursive(node, root.left);
		}
		else
			root.right = insertNodeRecursive(node, root.right);
		return root;
	}
	
	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}
	
	void printInorder(){
		printInorder(root);
	}
	
	static int height(Node node) {
		
		if (node == null)
			return 0;
		
		return (1+Math.max(height(node.left),height(node.right)));
	}
    int height() {
    	return height(root);
    }
    
    int diameter(Node root) {
    	if (root == null)
    		return 0;
    	
    	int lheight = height(root.left);
    	int rheight = height(root.right);
    	
    	int ldiameter = diameter(root.left);
    	int rdiameter = diameter(root.right);
    	
    	return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
    }
    
    int diameter() {
    	return diameter(root);
    }
}

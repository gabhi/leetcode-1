//      1
//     / \
//    2   3
//   / \   \
//  4   5   7
public class NextRightPointers2 {

	// A dummy level node before each level
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelNode = new TreeLinkNode(0);
        // Go down
        while(root != null) {
        	// Go right
        	TreeLinkNode p = levelNode;
        	while(root != null) {
	            if(root.left != null) {
	                p.next = root.left;
	                p = p.next;
	            }
	            if(root.right != null) {
	            	p.next = root.right;
	            	p = p.next;
	            }
	            root = root.next;
	        }

	        root = levelNode.next;
	        levelNode.next = null;
	    }
    }

    public static void main(String[] args) {
    	System.out.println("[Question] " + "Next Right Pointers");
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
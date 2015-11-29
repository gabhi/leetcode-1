import java.util.*;

class ClosestBinarySearchTreeValue2 {

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> smaller = new ArrayDeque<>();
        Deque<TreeNode> bigger = new ArrayDeque<>();
        
        // Initialization
        TreeNode p = root;
        while(p != null) {
            if(target < p.val) {
                bigger.push(p);
                p = p.left;
            } else {
                smaller.push(p);
                p = p.right;
            }
        }
        
        // Pop values
        while(result.size() < k) {
            if((bigger.isEmpty()) || 
                (!smaller.isEmpty() && (target - smaller.peek().val) < (bigger.peek().val - target))) {
                p = smaller.pop();
                result.add(p.val);
                
                // Get next smaller
                p = p.left;
                while(p != null)  {
                    smaller.push(p);
                    p = p.right;
                }
                
            } else {
                p = bigger.pop();
                result.add(p.val);
        
                // Get next bigger
                p = p.right;
                while(p != null) {
                    bigger.push(p);
                    p = p.left;
                }
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		double target = 3.428571;
		int k = 1;
		new ClosestBinarySearchTreeValue2().closestKValues(root, target, k);
		System.out.println("[info] " + "This is a very interesting problem!");
	}
}
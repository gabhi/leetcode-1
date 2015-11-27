// Remember that start == end is always checked for recursion ending (leaves / origin num)
public class RangeSumQueryMutable {
    
    Node tree;

    public RangeSumQueryMutable(int[] nums) {
        tree = buildTree(nums, 0, nums.length - 1);   
    }
    public Node buildTree(int[] nums, int start, int end) {
    	if(start > end) {
    		return null;
    	} else {
    		Node root = new Node(start, end);
    		if(start == end) {
    			root.sum = nums[start]; 
    			return root;
    		}
    		int mid = start + (end - start) / 2;
	        root.left = buildTree(nums, start, mid);  // I guess mid + 1 is ok too
	        root.right = buildTree(nums, mid + 1, end); 
	        root.sum = root.left.sum + root.right.sum;
	        return root;
    	}    	
    }

    void update(int i, int val) {
    	update(tree, i, val);
    }
    void update(Node root, int i, int val) {
    	int start = root.start, end = root.end;
    	System.out.println("\n --- " + start + " " + end +  " ---\n");
    	if(start == end) {
    		root.sum = val;
    	} else if(start < end) {
			int mid = start + (end - start) / 2;
			if(i <= mid) update(root.left, i, val);
			else update(root.right, i, val);
			root.sum = root.left.sum + root.right.sum;  // similar to DFS
    	}
     }

    public int sumRange(int i, int j) {
    	return sumRange(tree, i, j);
    }
    public int sumRange(Node root, int i, int j) {
    	if(root == null) return 0;
     	int start = root.start, end = root.end;
     	if(start == i && end == j) {
     		return root.sum;
     	} else {
     		int mid = start + (end - start) / 2;
     		if(j <= mid) {  // Deliver the task to the child
     			return sumRange(root.left, i, j);
     		} else if(i >= mid + 1) {
     			return sumRange(root.right, i, j);
     		} else {
     			return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
     		}
     	}
    }

    public static void main(String[] args) {
    	int[] nums = {1, 3, 5};
    	RangeSumQueryMutable q = new RangeSumQueryMutable(nums);
    	System.out.println(q.sumRange(0, 2));
    	q.update(1, 2);
    	System.out.println(q.sumRange(0, 2));
    }
}


// Segment Tree
class Tree {
	Node root;
}

class Node {
	int start, end, sum;
	Node left, right;
	public Node(int start, int end) {
		this.start = start; 
		this.end = end; // Have
	}
}
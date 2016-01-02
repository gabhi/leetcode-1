import java.util.*;

class BinaryTreeVerticalOrderTraversal {
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		
		q.add(root); 
		cols.add(0);

		int min = 0, max = 0;
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();
			if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
			map.get(col).add(node.val);

			if(node.left != null) {
				q.add(node.left); 
				cols.add(col - 1);
				if(col <= min) min = col - 1;
			}
			if(node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				if(col >= max) max = col + 1;
			}
		}

		for(int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
    }


    public static void main(String[] args) {}
}
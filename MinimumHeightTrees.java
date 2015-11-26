// https://leetcode.com/discuss/71738/easiest-75-ms-java-solution

import java.util.*;

class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    List<Integer> leaves = new ArrayList<>();  
	    if(n <= 1) {leaves.add(0); return leaves;}

	    // Construct adjencent graph
	    Map<Integer, Set<Integer>> graph = new HashMap<>();   
	    for(int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
	    for(int[] e : edges) {
	        graph.get(e[0]).add(e[1]);
	        graph.get(e[1]).add(e[0]);
	    }

	    // Add leaves which have one leaf
	    for(int i = 0; i < n; i++) {
	        if(graph.get(i).size() == 1) leaves.add(i);
	    }

	    // Remove leaves level by level
	    while(n > 2) {
	        List<Integer> newLeaves = new ArrayList<>();
	        for(int leaf : leaves) {
	            for(int nb : graph.get(leaf)) {
	                // Remove connection
	                graph.get(leaf).remove(nb);
	                graph.get(nb).remove(leaf);
	                n--;
	                if(graph.get(nb).size() == 1) {
	                    newLeaves.add(nb);
	                }
	            }
	        }
	        leaves = newLeaves;
	    }
	    return leaves;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
		
		// n = 6;
		// int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

		List<Integer> res = new MinimumHeightTrees().findMinHeightTrees(n, edges);
		System.out.println(res.toString());
	}
}
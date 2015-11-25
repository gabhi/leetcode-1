/*
https://leetcode.com/discuss/69572/easiest-java-solution-written-in-10-mins

This is a very basic union-find problem. Given a graph with points being added, we can at least solve:

How many islands in total?
Which island is pointA belong to?
Are pointA and pointB connected?
The idea is simple. To represent a list of islands, we use trees. i.e., a list of roots. This helps us find the identifier of an island faster. If roots[c] = p means the parent of node c is p, we can climb up the parent chain to find out the identifier of an island, i.e., which island this point belongs to:

Do root[root[roots[c]]]... until root[c] == c;
To transform the two dimension problem into the classic UF, perform a linear mapping:

int id = n * x + y;
Initially assume every cell are in non-island set {-1}. When point A is added, we create a new root, i.e., a new island. Then, check if any of its 4 neighbors belong to the same island. If not, union the neighbor by setting the root to be the same. Remember to skip non-island cells.

UNION operation is only changing the root parent so the running time is O(1).

FIND operation is proportional to the depth of the tree. So the average running time is O(logn), and a sequence of m operations take O(mlogn). If there is no balancing, the worse case could be O(mn).

Here I've attached my 15ms solution. There can be at least two improvements: union by rank & pass compression. However I suggest first finish the basis, then discuss the improvements with interviewer.

Cheers!

*/

import java.util.*;

public class NumberOfIsland2 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if(m <= 0 || n <= 0) return result;
        
        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);         
        
        for(int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;             // add new island
            count++;
            
            for(int[] dir : dirs) {
                int x = p[0] + dir[0]; 
                int y = p[1] + dir[1];
                int idNb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[idNb] == -1) continue;
                 
                int rootNb = findIsland(roots, idNb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[rootNb] = root;   // union two islands 
                    count--;               
                }
            }
            
            result.add(count);
        }
        return result;
    }
    
    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }

    public static void main(String[] args) {}   
}
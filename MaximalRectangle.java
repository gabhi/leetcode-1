import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
    	int max = 0, m = matrix.length, n = matrix[0].length;    	
    	int[] height = new int[n + 1]; // last height is always 0. To calcluate things inside the stack
    	for(int i = 0; i < m; i++) {
    		Deque<Integer> s = new ArrayDeque<>();
    		for(int j = 0; j <= n; j++) {
    			if(j < n) {
    				System.out.println(m + " " + j);
    				if(matrix[i][j] == '1') height[j]++;
    				else height[j] = 0;
    			}
    			
    			if(s.isEmpty() || height[j] >= height[s.peek()]) {
    				s.push(j);
    			} else { // s is not empty
    				while(!s.isEmpty() && height[j] < height[s.peek()]) {
    					int p = s.pop();
    					int w = s.isEmpty() ? j : (j - s.peek() - 1);
    					int h = height[p];
    					max = Math.max(max, w * h);
    				}
    				s.push(j);
    			}
    		}
    	}
    	return max;
    }
    public static void main(String[] args) {
    	char [][] m = {{'1'}};
		int res = new MaximalRectangle().maximalRectangle(m);
		System.out.println("res: " + res);
    }
}
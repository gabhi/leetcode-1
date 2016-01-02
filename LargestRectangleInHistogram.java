import java.util.*;
// Similar to 

class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	int len = height.length, max = 0;
    	for(int i = 0; i <= len;) {
    		int h = (i == len ? 0 : height[i]);
    		
    		// Push larger ones onto stack
    		if(stack.isEmpty() || (h >= height[stack.peek()])) {
    			stack.push(i++);
    			
    		// Stop and start calculating 
    		} else {
    			int pop = stack.pop();
    			int w = stack.isEmpty() ? i : (i - 1 - stack.peek());
    			max = Math.max(max, height[pop] * w);
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		int [] height = {1};
		int res = new LargestRectangleInHistogram().largestRectangleArea(height);
		System.out.println("res: " + res);
	}
}

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null ||  nums.length == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> q = new ArrayDeque<>();   
		int idx = 0;
		for(int i = 0; i < nums.length; i++) {
			// Remove out of range from the head
			while(!q.isEmpty() && q.peek() <= i - k) {
				q.poll();
			}
			// Anything smaller than current is useless
			while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// If at least is a window
			q.add(i);// Add index!!!
			if(i >= k - 1) {
				res[idx++] = nums[q.peek()];  // Remember it's index!!!
			}
		}
		return res;
		
    }
	public static void main(String[] args) {}
}
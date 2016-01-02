/*
给一堆租房的request，作为输入数组，找一个array subset，其中任意两个元素不能相邻，（因为要打扫房间），求使得子集里所有元素之和最大。一维DP解之，另外可以使用滚动数组让空间开销为常数。
不相邻的range 求和最大 [check-in date, check-out date/ check-in date, check-out date/ check-in date,….]求最多能租出去几天。
*/

class MaxSum {

	public static int maxSum(int[] nums) {
		// dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		// Let dp1 = dp[i - 1]
		// Let dp2 = dp[i - 2]
		int dp1 = 0, dp2 = 0;
		for(int i = 0; i < nums.length; i++) {
			int dp0 = Math.max(dp1, dp2 + nums[i]);
			dp2 = dp1;
			dp1 = dp0;
		}
		return dp1;
	}

	public static void main(String[] args) {
		int nums[] = {1, -1, 5, 4, 0, 2};
		int res = maxSum(nums);
		System.out.println("Res: " + res);
	}	
}
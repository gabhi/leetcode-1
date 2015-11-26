public class RangeSum2DImmutable {
    int[][] dp;

    public RangeSum2DImmutable(int[][] matrix) {
   		if(matrix == null || matrix[0].length == 0) return;
   		for(int i = 1; i <= matrix.length; i++) {
   			for(int j = 1; j <= matrix[0].length; j++) {
   				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i -  1][j - 1] + matrix[i - 1][j - 1];
   			}
   		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1 + 1][col2 + 1] - dp[row2 + 1][col1 + 1] + dp[row2 + 1][col2 + 1];
    }

    public static void main(String[] args) {
    	int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
    	for(int[] m : matrix) {
    		for(int val : m) {
    			System.out.print(val + " ");
    		}
    		System.out.print("\n");
    	}
    	int res = new RangeSum2DImmutable(matrix).sumRegion(2, 1, 4, 3);
    	System.out.print(res);
    }
}
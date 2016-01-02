// word 1: i, word 2: j
// if(c == d)
// dp[i][j] = dp[i - 1][j - 1] 

// if(c != d)
// dp[i][j] = min(dp[i - 1][j - 1] + 1   replace, 
//            min(dp[i][j - 1] + 1), insert
// 			  min(dp[i - 1][j] + 1), delete

// initial states
// dp[i][0]= i
// dp[0][j] = j

class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[] dp = new int[n + 1];
		for(int j = 1; j <= n; j++) dp[j] = j;

		for(int i = 1; i <= m; i++) {
		    int upLeft = dp[0];
			dp[0] = i;
			for(int j = 1; j <= n; j++) {
				int tmp = dp[j];
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[j] = upLeft;  // upLeft = dp[i - 1][j - 1];
				else {
					dp[j] = Math.min(dp[j - 1] + 1, Math.min(dp[j] + 1, upLeft + 1));
				}
				upLeft = tmp;
			}
		}
 		return dp[n];
    }

    public static void main(String[] args) {}
}
class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // dp[i][j] = num of distinct for index i for t, index j (smaller) for s (bigger)
        // if t[i] == s[j], dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] ===> dp[i - 1] + upLeft;
        // if t[i] != s[j], dp[i][j] = dp[i][j - 1] ===> dp[i - 1]
        int m = t.length(), n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);      // pay attention
        for(int i = 1; i <= m; i++) {
            int upLeft = dp[0];  // Pay attention
            dp[0] = 0;
            for(int j = 1; j <= n; j++) {
                int temp = dp[j];
                dp[j] = dp[j - 1];
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[j] += upLeft;
                }
                upLeft = temp;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {}
}
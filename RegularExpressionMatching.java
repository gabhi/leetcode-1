// dp[i][j] means s[0, i) matches p[0, j).

// a  a  a           a  a  *
//      i-1  i)           j-1 j) 

class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
    	boolean[][] dp = new boolean[m + 1][n + 1];
    	dp[0][0] = true;

    	// dp[0][i] means empty string matches patterns. This is only valid when p=a*b*c*"
    	for(int j = 1; j <= n; j++) {  // 注意是从1 
    		dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2]; 
    	}
    	for(int i = 1; i <= m; i++) { 
    		for(int j = 1; j <= n; j++) {
    			if(p.charAt(j - 1) != '*') {
    				dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
    			} else {
    				dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
    			}
    		}
    	}
    	return dp[m][n];
    }
    
    public static void main(String[] args) {}
}
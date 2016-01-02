// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

import java.util.*;

// 9: 44
class InterleavingString {
	// method 1: dp 2d, 4ms
    public boolean isInterleave(String s1, String s2, String s3) {
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
		int m = c1.length, n = c2.length;
		if(m + n != c3.length) return false;
		
		boolean[][] dp = new boolean[m + 1][n + 1];  //  i = 0 means no char; i = 1 means position 0
		dp[0][0] = true;
		for(int i = 1; i <= m; i++) {
			dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i - 1];
		}
		for(int j = 1; j <= n; j++) {
			dp[0][j] = dp[0][j - 1] && c2[j - 1] == c3[j - 1];
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i - 1][j] && c1[i - 1] == c3[i + j - 1]) || // extends from i - 2, k - 1
					(dp[i][j - 1] && c2[j - 1] == c3[i + j - 1]); // extends from j - 2, k - 1
			}
		}
		for(boolean[] r : dp) {
			for(boolean i : r) {
				System.out.print((i ? 1 : 0) + " ");
			}
			System.out.println();
		}
		System.out.println();
        return dp[m][n];
    }

    // method 2: dp 1d, 5ms
    public boolean isInterleave1D(String s1, String s2, String s3) {
    	char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
    	int m = c1.length, n = c2.length;
    	if(m + n != c3.length) return false;

    	boolean [] dp = new boolean[n + 1];
    	dp[0] = true;
    	for(int j = 1; j <= n; j++) {
    		dp[j] = dp[j - 1] && c2[j - 1] == c3[j - 1];
    	}
    	for(int i = 1; i <= m; i++) {
    		dp[0] = (dp[0] && c1[i - 1] == c3[i - 1]);
    		for(int j = 1; j <= n; j++) {
    			dp[j] = dp[j] && c1[i - 1] == c3[i + j - 1] ||
    				dp[j - 1] && c2[j - 1] == c3[i + j - 1];
    		}
    	}
        return dp[n];
    }

    // bfs
    public boolean isInterleaveDFS(String s1, String s2, String s3) {
	    int m = s1.length(), n = s2.length();
	    if(m + n != s3.length()) return false;
	    return dfs(s1, s2, s3, 0, 0, 0, new boolean[m + 1][n + 1]);
	}

	public boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
	    if(invalid[i][j]) return false;
	    if(k == s3.length()) return true;
	    boolean valid = 
	        i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, invalid) || 
	        j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, invalid);
	    if(!valid) invalid[i][j] = true;
	    return valid;
	}
	    

	public static void main(String[] args) {
		boolean res = new InterleavingString().isInterleaveDFS("ab", "cd", "acbd");	
		// 1 0 0 
		// 1 1 0 
		// 0 1 1 
		System.out.println(res);
	}

}

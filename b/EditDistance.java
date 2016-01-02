
/*
题目是给定一个word list 和一个target word，要求输出在word list 里跟target 
word的edit distance 相差不大于k的所有words。我写了一个基于edit distance的解 
法(见下面)，程序是要从头到尾都要写，包括main函数和test数据。写完后他问有没有 
更好的解法，我说可以用trie，但是我不觉得我能在剩余时间里写得出来基于trie的解 
法，就大致说了一下我认为的思路。在此也求大牛给一个基于trie解法的code。
*/


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

    public static void main(String[] args) {
    }
}

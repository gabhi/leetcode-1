import java.util.*;

class LongestValidParentheses {
	// V[i] longest paren ending at index i and including s[i]
	// 4ms
	public int longestValidParenthesesDP(String s) {
		int max = 0, open = 0;
		char[] c = s.toCharArray();
		int[] dp = new int[c.length + 1];
		for(int i = 0; i < c.length; i++) {
			if(c[i] == '(') open++;
			else {
				if(open > 0) {
					dp[i] = 2 + dp[i - 1];
					if(i - dp[i] >= 0) dp[i] += dp[i - dp[i]];
					open--;
				}
			}
			max = Math.max(max, dp[i]);
		}
        return max;
    }

    // 11ms
    // Store parentheses haven't paired up
	public int longestValidParentheses(String s) {
    	int max = 0;
    	char[] c = s.toCharArray();
    	Deque<Integer> stack = new ArrayDeque<>();
    	stack.push(-1);  // Pretending a ) at index -1
		for(int i = 0; i < c.length; i++) {
			if(stack.peek() != -1 && c[stack.peek()] == '(' && c[i] == ')') {
			    stack.pop();
				max = Math.max(max, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
    	return max;   
    }

    public static void main(String[] args) {
    	// int res = new LongestValidParentheses().longestValidParentheses("()");
    	int res = new LongestValidParentheses().longestValidParenthesesDP("()");
    	System.out.println(res);
    }
}
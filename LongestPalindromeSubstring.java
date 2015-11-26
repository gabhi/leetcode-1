public class LongestPalindromeSubstring {
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int maxLen = 1, start = 0;
        for(int i = 0; i < s.length();) {  // i不要＋＋
            int left = i, right = i;
            // Avoid duplication
            while(right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }  
            i = right + 1;  // This will much quicker!
            
            // Expand
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            
            // Update length
            int len = right - left - 1;
            if(len > maxLen) {
                maxLen = len;
                start = left + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String res = new LongestPalindromeSubstring().longestPalindrome("aab");
        System.out.println(res);
    }   
}
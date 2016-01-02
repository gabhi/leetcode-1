import java.util.*;

// 1. first find the window in bigger covering smaller
// 2. Then shrink the window i
// 3. update min in every iteration

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return "";
        
        int[] small = new int[256]; // smaller str chars
        int[] window = new int[256];// window chars already covered
        for(int i = 0; i < t.length(); i++) {
            small[t.charAt(i)]++;
        }
        int covered = 0, start = 0, minLen = Integer.MAX_VALUE;
        for(int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(small[c] != 0) {
                window[c]++;
                if(window[c] <= small[c]) {
                    covered++;
                }
            }
            
            if(covered >= t.length()) {
                // Shrink i for every uncovered letter, or covered letters but appear too many times
                while(small[s.charAt(i)] == 0 || window[s.charAt(i)] > small[s.charAt(i)]) {
                    window[s.charAt(i)]--;
                    i++;
                }
                if(j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
    	String s = "a", t = "aa";
    	String res = new MinimumWindowSubstring().minWindow(s, t);

    	System.out.println("[res] " + res);
    }
}
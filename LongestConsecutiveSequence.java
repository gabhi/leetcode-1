// Only store len in the boundary
import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int k : nums) {
            if(map.containsKey(k)) continue;
            map.put(k, 1);
            
            int lo = k, hi = k;
            if(map.containsKey(k - 1)) lo = k - map.get(k - 1);
            if(map.containsKey(k + 1)) hi = k + map.get(k + 1);
            
            int len = hi - lo + 1;
            max = Math.max(max, len);
            map.put(lo, len);
            map.put(hi, len);
        }   
        
        return max;
    }

    public static void main(String[] args) {
    	int[] nums = {100, 4, 200, 1, 3, 2};
    	int res = new LongestConsecutiveSequence().longestConsecutive(nums);
    	System.out.println("[info] " + res);
    }
}
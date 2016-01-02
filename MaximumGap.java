import java.util.*;

public class MaximumGap {
  public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int n  = nums.length;
        int min = nums[0], max = nums[0];
        // Get min / max 
        for(int i = 1; i < n; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        
        // Init buckets
        double len = (double) (max - min) / (n - 1); 

        int[] mins = new int[n];
        int[] maxs = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        
        // Put into buckets
        for(int num : nums) {
            int id = (int) ((num - min) / len);
            mins[id] = Math.min(mins[id], num);
            maxs[id] = Math.max(maxs[id], num);
        }
        
        // Calculate gaps
        int gap = 0, prev = maxs[0];
        for(int i = 1; i < n; i++) {   //  是n
            //  最后一个bucket只有一个，在最后一个index : n - 1。
            //
            if(mins[i] == Integer.MAX_VALUE) continue;
            gap = Math.max(gap, mins[i] - prev);
            prev = maxs[i];
        }

        return gap;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10000000};
        int res = new MaximumGap().maximumGap(nums);
        System.out.println(res);
    }
}
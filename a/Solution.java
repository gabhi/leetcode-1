public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int n  = nums.length;
        int[] min = new int[n - 1];
        int[] max = new int[n - 1];
        int min = nums[0], max = nums[0];
      
        for(int i = 1; i < n; i++) {
            if(num[i] < min) min = num[i];
            if(num[i] > max) max = num[i];
        }
        
        double diff = (max - min) / (n - 1); 
        for(int num : nums) {
            int id = num == max ? (n - 2) : (num - min) / diff;
            min[id] = Math.min(min[id], num);
            max[id] = Math.max(max[id], num);
        }
        
        int maxGap = 0;
        for(int i = 1; i < n - 1; i++) {
            int gap = min[i] - max[i - 1];
            if(gap > maxGap) maxGap = gap;
        }
        
        return maxGap;
    }

    public static void main(String[] args) {}
}
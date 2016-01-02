public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	// Bucket sort
    	int n = nums.length;
        for(int i = 0; i < n; i++) {
        	while(i + 1 != nums[i]) {
        		if(nums[i] < 1 || nums[i] > n) break;
        		if(nums[i] == nums[nums[i] - 1]) break;
        		
        		int tmp = nums[i];
        		nums[i] = nums[tmp - 1];
        		nums[tmp - 1] = tmp;
        	}
        }

        for(int i = 0; i < n; i++) {
        	if(i != nums[i] - 1) return i + 1;
        }

        return n + 1;

    }
    public static void main(String[] args) {}
}
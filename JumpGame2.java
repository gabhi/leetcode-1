public class JumpGame2 {
    public int jump(int[] nums) {
        int edge = 0;
        int maxReach = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++) { // Only goes to the one before the end
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i == edge) { 
                steps++;
                edge = maxReach;
            }
        }
        return steps;        
    }
    public static void main(String[] args) {}
}
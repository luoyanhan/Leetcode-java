package Medium;

public class No55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int maxLocation=0;
            for (int cur=0; cur<nums.length; cur++){
                if (cur<=maxLocation){
                    maxLocation = Math.max(maxLocation, nums[cur]+cur);
                    if (maxLocation>=nums.length-1){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

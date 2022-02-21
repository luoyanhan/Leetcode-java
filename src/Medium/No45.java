package Medium;

public class No45 {
    class Solution {
        public int jump(int[] nums) {
            int step = 0, farest=0, nextLocation=0, len=nums.length;
            for (int idx=0; idx<len-1; idx++){
                farest = Math.max(farest, idx+nums[idx]);
                if (idx==nextLocation){
                    step++;
                    nextLocation = farest;
                }
            }
            return step;
        }
    }
}

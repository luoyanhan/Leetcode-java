package Medium.NO53;

class Solution {
    public int maxSubArray(int[] nums) {
        int length=nums.length, max=nums[0], pre=0;
        for (int i=0; i<length; i++){
            pre = Math.max(pre+nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}

package Medium.NO55;

class Solution {
    public boolean canJump(int[] nums) {
        int max=0, length=nums.length;
        for (int pos=0; pos<length; pos++){
            if (max>=pos){
                max = Math.max(max, pos+nums[pos]);
                if (max>=length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
package Medium.NO45;

class Solution {
    public int jump(int[] nums) {
        int len = nums.length, end=0, step=0, maxPos=0;
        for (int pos=0; pos<len-1; pos++){
            maxPos = Math.max(maxPos, pos+nums[pos]);
            if (end==pos){
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}

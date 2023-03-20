package Medium.NO198;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==1){
            return nums[0];
        }
        int[] records = new int[len+1];
        records[0] = 0;
        records[1] = nums[0];
        records[2] = Math.max(nums[0], nums[1]);
        for (int idx=3; idx<=len; idx++){
            records[idx] = Math.max(records[idx-2] + nums[idx-1], records[idx-1]);
        }
        return records[len];
    }
}

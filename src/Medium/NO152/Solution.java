package Medium.NO152;

class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] records = new int[length+1][2];
        records[1][0] = nums[0];
        records[1][1] = nums[0];
        for (int idx=2; idx<=length; idx++){
            int num = nums[idx-1];
            records[idx][0] = Math.max(records[idx-1][0]*num, records[idx-1][1]*num);
            records[idx][0] = Math.max(records[idx][0], num);
            records[idx][1] = Math.min(records[idx-1][0]*num, records[idx-1][1]*num);
            records[idx][1] = Math.min(records[idx][1], num);
        }
        int res = records[1][0];
        for (int idx=2; idx<=length; idx++){
            res = Math.max(records[idx][0], res);
        }
        return res;
    }
}

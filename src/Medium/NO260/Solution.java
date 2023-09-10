package Medium.NO260;

class Solution {
    public int[] singleNumber(int[] nums) {
        int twoXOR = 0;
        for (int i=0; i<nums.length; i++){
            twoXOR ^= nums[i];
        }
        int leftFirstOne = twoXOR & (-twoXOR);
        int res1 = 0, res2 = 0;
        for (int i=0; i<nums.length; i++){
            if ((nums[i]&leftFirstOne)!=0) {
                res1 ^= nums[i];
            } else {
                res2 ^= nums[i];
            }
        }
        return new int[]{res1, res2};
    }
}

package Medium.NO80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length<2){
            return length;
        }
        int fast=2, slow=2;
        while (fast<length){
            if (nums[slow-2]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}

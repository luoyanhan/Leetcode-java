package Medium;

public class No31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int idx1 = len-2, idx2 = len-1;
            while (idx1>=0 && nums[idx1]>=nums[idx1+1]){
                idx1--;
            }
            if (idx1>=0) {
                while (idx2 >= 0 && nums[idx2] <= nums[idx1]) {
                    idx2--;
                }
                int tmp = nums[idx1];
                nums[idx1] = nums[idx2];
                nums[idx2] = tmp;
            }
            int left = idx1 + 1, right = len - 1;
            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }
}

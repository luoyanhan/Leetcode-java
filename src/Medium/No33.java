package Medium;

public class No33 {
    class Solution {
        public int search(int[] nums, int target) {
            int len=nums.length, left=0, right=len-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (target==nums[mid]){
                    return mid;
                }
                if (nums[mid]>=nums[0]){
                    if (target>=nums[0] && target<nums[mid]){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }else {
                    if (target>nums[mid] && target<=nums[len-1]){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}

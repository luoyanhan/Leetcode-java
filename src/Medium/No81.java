package Medium;

public class No81 {
    class Solution {
        public boolean search(int[] nums, int target) {
            int length = nums.length;
            int left = 0, right = length-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (nums[mid]==target){
                    return true;
                }
                if (nums[mid]==nums[left] && nums[mid]==nums[right]){
                    left++;
                    right--;
                }else if (nums[mid]>=nums[left]){
                    if (target>=nums[left] && target<=nums[mid]){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }else {
                    if (target>=nums[mid] && target<=nums[right]){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }
            }
            return false;
        }
    }
}

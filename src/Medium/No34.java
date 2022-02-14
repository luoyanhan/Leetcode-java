package Medium;

public class No34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len==0){
                return new int[]{-1, -1};
            }
            int left = findLeft(nums, target);
            int right = findRight(nums, target);
            return new int[]{left, right};
        }
        public int findLeft(int[] nums, int target){
            int left=0, right=nums.length-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (target==nums[mid]){
                    right = mid-1;
                }else if (target<nums[mid]){
                    right= mid-1;
                }else if (target>nums[mid]){
                    left = mid+1;
                }
            }
            if (left>nums.length-1 || nums[left]!=target){
                return -1;
            }
            return left;
        }
        public int findRight(int[] nums, int target){
            int left=0, right=nums.length-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                if (target==nums[mid]){
                    left = mid+1;
                }else if (target>nums[mid]){
                    left= mid+1;
                }else if (target<nums[mid]){
                    right = mid-1;
                }
            }
            if (right<0 || nums[right]!=target){
                return -1;
            }
            return right;
        }
    }
}

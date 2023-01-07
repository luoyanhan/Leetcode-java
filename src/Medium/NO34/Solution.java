package Medium.NO34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchLeft(nums, target), binarySearchRight(nums, target)};
    }

    public int binarySearchLeft(int[] nums, int target){
        int len = nums.length, left = 0, right = len-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                right = mid-1;
            }else if (target<nums[mid]){
                right = mid-1;
            }else if (target>nums[mid]){
                left = mid+1;
            }
        }
        if (left>=len || nums[left]!=target){
            return -1;
        }
        return left;
    }

    public int binarySearchRight(int[] nums, int target){
        int len = nums.length, left = 0, right = len-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                left = mid+1;
            }else if (target<nums[mid]){
                right = mid-1;
            }else if (target>nums[mid]){
                left = mid+1;
            }
        }
        if (right<0 || nums[right]!=target){
            return -1;
        }
        return right;
    }
}

package Medium.NO33;

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len==1){
            return target==nums[0]?0:-1;
        }
        int right = len-1, left = 0;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[0]<=nums[mid]){
                if (nums[0]<=target && target<nums[mid]){
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

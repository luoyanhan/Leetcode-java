package Medium.NO162;

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int res = 0;
        if (len==1) {
            return res;
        }
        int left=0, right=len-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (mid==0){
                if (nums[mid]>nums[mid+1]){
                    res = mid;
                    break;
                }else {
                    left = mid+1;
                }
            }else if (mid==len-1){
                if (nums[mid]>nums[mid-1]){
                    res = mid;
                    break;
                }else {
                    right = mid-1;
                }
            }else {
                if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                    res = mid;
                    break;
                }else if (nums[mid]>nums[mid-1]){
                    left = mid+1;
                }else if (nums[mid]>nums[mid+1]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return res;
    }
}

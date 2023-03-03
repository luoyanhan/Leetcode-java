package Medium.NO153;

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int res = nums[0];
        while (left<right){
            int mid = left + (right-left)/2;
            int num = nums[mid];
            res = Math.min(res, num);
            if (num<nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }
}

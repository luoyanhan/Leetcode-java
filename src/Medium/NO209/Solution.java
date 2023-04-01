package Medium.NO209;

//class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int sum = 0;
//        int res = Integer.MAX_VALUE;
//        int left = 0;
//        int right = 0;
//        int len = nums.length;
//        while (right<len){
//            sum += nums[right];
//            while (sum>=target){
//                res = Math.min(res, right-left+1);
//                sum -= nums[left];
//                left++;
//            }
//            right++;
//        }
//        return res==Integer.MAX_VALUE?0:res;
//    }
//}


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int[] preSum = new int[len+1];
        for (int i=0; i<len; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int idx=0; idx<len; idx++){
            int sum = target + preSum[idx];
            int pos = bin(preSum, sum);
            if (pos<0){
                pos = -pos-1;
            }
            if (pos<=len){
                res = Math.min(res, pos-idx);
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    public int bin(int[] nums, int target){
        int left=0, right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if (target>nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}

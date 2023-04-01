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

import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int[] preSum = new int[len+1];
        for (int i=0; i<len; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int idx=1; idx<=len; idx++){
            int sum = target + preSum[idx-1];
            int pos = Arrays.binarySearch(preSum, sum);
            if (pos<0){
                pos = -pos-1;
            }
            if (pos<=len){
                res = Math.min(res, pos-idx+1);
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}

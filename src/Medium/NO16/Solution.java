package Medium.NO16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int best = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for (int first=0; first<len; first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int second = first+1, third = len-1;
            while (second<third){
                int sum = nums[first] + nums[second] + nums[third];
                if (sum==target){
                    return target;
                }
                if (Math.abs(sum-target) < Math.abs(best-target)){
                    best = sum;
                }
                if (sum>target){
                    int tmpThird = third-1;
                    while (tmpThird>second && nums[third]==nums[tmpThird]){
                        tmpThird -= 1;
                    }
                    third = tmpThird;
                }else {
                    int tmpSecond = second+1;
                    while (tmpSecond<third && nums[second]==nums[tmpSecond]){
                        tmpSecond += 1;
                    }
                    second = tmpSecond;
                }
            }
        }
        return best;
    }
}

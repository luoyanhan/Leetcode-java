package Medium.NO18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if (nums==null || nums.length<4){
            return answers;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int first=0; first<len-3; first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            if ((long)nums[first] + nums[first+1] + nums[first+2] + nums[first+3] > target){
                break;
            }
            if ((long)nums[first] + nums[len-1] + nums[len-2] + nums[len-3] < target){
                continue;
            }
            for (int second=first+1; second<len-2; second++){
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                if ((long)nums[first] + nums[second] + nums[second+1] + nums[second+2] > target){
                    break;
                }
                if ((long)nums[first] + nums[second] + nums[len-1] + nums[len-2] < target){
                    continue;
                }
                int third = second+1, forth = len-1;
                while (third<forth){
                    long sum = nums[first] + nums[second] + nums[third] + nums[forth];
                    if (sum==target){
                        List<Integer> answer = new ArrayList<Integer>(
                                Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
                        answers.add(answer);
                        int tmpThird = third+1;
                        while (tmpThird<forth && nums[tmpThird]==nums[third]){
                            tmpThird++;
                        }
                        third = tmpThird;
                        int tmpForth = forth-1;
                        while (tmpForth>third && nums[forth]==nums[tmpForth]){
                            tmpForth--;
                        }
                        forth = tmpForth;
                    }else if (sum>target){
                        int tmpForth = forth-1;
                        while (tmpForth>third && nums[forth]==nums[tmpForth]){
                            tmpForth--;
                        }
                        forth = tmpForth;
                    }
                    else {
                        int tmpThird = third+1;
                        while (tmpThird<forth && nums[tmpThird]==nums[third]){
                            tmpThird++;
                        }
                        third = tmpThird;
                    }
                }
            }
        }
        return answers;
    }
}

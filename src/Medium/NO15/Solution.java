package Medium.NO15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        int len = nums.length;
        for (int first=0; first<len; first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int target = -nums[first], third = len-1;
            for (int second=first+1; second<len; second++){
                if (second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third && nums[second] + nums[third] > target){
                    third--;
                }
                if (second==third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> answer = new ArrayList<Integer>();
                    answer.add(nums[first]);
                    answer.add(nums[second]);
                    answer.add(nums[third]);
                    answers.add(answer);
                }
            }
        }
        return answers;
    }
}

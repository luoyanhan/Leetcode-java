package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums==null || nums.length<4){
                return res;
            }
            int len = nums.length;
            Arrays.sort(nums);
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
                    int left=second+1, right=len-1;
                    while (left<right){
                        int sum = nums[first] + nums[second] + nums[left] + nums[right];
                        if (sum==target){
                            res.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
                            left++;
                            while (left<right && nums[left]==nums[left-1]){
                                left++;
                            }
                            right--;
                            while (left<right && nums[right]==nums[right+1]){
                                right--;
                            }
                        }else if (sum<target){
                            left++;
                            while (left<right && nums[left]==nums[left-1]){
                                left++;
                            }
                        }else {
                            right--;
                            while (left<right && nums[right]==nums[right+1]){
                                right--;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}

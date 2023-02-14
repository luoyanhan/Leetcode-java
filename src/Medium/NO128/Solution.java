package Medium.NO128;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int res = 0;
        for (int num:set){
            if (!set.contains(num-1)){
                int len = 1;
                int tmp = num;
                while (set.contains(tmp+1)){
                    tmp++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}

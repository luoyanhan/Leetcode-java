package Medium;

import java.util.HashMap;

public class No3 {
    public static void main(String[] args){
        Solution s = new Solution();
        int res = s.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0, end = 0;
            while (end < s.length()){
                Character cur = s.charAt(end);
                if (map.containsKey(cur)){
                    start = Math.max(map.get(cur) + 1, start);
                }
                maxLength = Math.max(maxLength, end-start+1);
                map.put(cur, end);
                end += 1;
            }
            return maxLength;
        }
    }
}

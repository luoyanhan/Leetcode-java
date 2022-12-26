package Medium.NO3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, right = -1, length = s.length();
        Set<Character> set = new HashSet<Character>();
        for (int left=0; left<length; left++){
            if (left>0){
                set.remove(s.charAt(left-1));
            }
            while (right+1<length && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right += 1;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}

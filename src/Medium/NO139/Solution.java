package Medium.NO139;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] record = new boolean[len+1];
        record[0] = true;
        for (int end=1; end<=len; end++){
            for (int mid=0; mid<end; mid++){
                if (wordDict.contains(s.substring(mid, end)) && record[mid]){
                    record[end] = true;
                    break;
                }
            }
        }
        return record[len];
    }
}

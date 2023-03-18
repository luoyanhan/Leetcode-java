package Medium.NO187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int subStringLength = 10;
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len<=subStringLength){
            return res;
        }
        int tmp = 0;
        for (int i=0; i<subStringLength-1; i++){
            tmp = (tmp<<2) | map.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i=subStringLength-1; i<len; i++){
            tmp = ((tmp<<2) | map.get(s.charAt(i))) & ((1<<20)-1);
            cnt.put(tmp, cnt.getOrDefault(tmp, 0)+1);
            if (cnt.get(tmp)==2){
                res.add(s.substring(i+1-subStringLength, i+1));
            }
        }
        return res;
    }
}

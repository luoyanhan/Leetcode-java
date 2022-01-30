package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17 {
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length()==0){
                return res;
            }
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            backtrack(0, digits, res, new StringBuffer(), map);
            return res;
        }

        public void backtrack(int idx, String digits, List<String> res, StringBuffer each, Map<Character, String> map){
            if (idx==digits.length()){
                res.add(each.toString());
            }else {
                Character strDigit = digits.charAt(idx);
                String words = map.get(strDigit);
                int wordsLength = words.length();
                for (int i=0; i<wordsLength; i++){
                    each.append(words.charAt(i));
                    backtrack(idx+1, digits, res, each, map);
                    each.deleteCharAt(each.length()-1);
                }
            }
        }
    }
}

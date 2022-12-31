package Medium.NO17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        Map<Character, Character[]> map = new HashMap<Character, Character[]>(){{
            put('2', new Character[]{'a', 'b', 'c'});
            put('3', new Character[]{'d', 'e', 'f'});
            put('4', new Character[]{'g', 'h', 'i'});
            put('5', new Character[]{'j', 'k', 'l'});
            put('6', new Character[]{'m', 'n', 'o'});
            put('7', new Character[]{'p', 'q', 'r', 's'});
            put('8', new Character[]{'t', 'u', 'v'});
            put('9', new Character[]{'w', 'x', 'y', 'z'});
        }};
        if (digits.length()==0){
            return res;
        }
        backtrack(map, res, digits, 0, new StringBuffer());
        return res;
    }

    private void backtrack(Map<Character, Character[]> map, List<String> res, String digits, int index, StringBuffer stringBuffer){
        if (index==digits.length()){
            res.add(stringBuffer.toString());
        }else {
            Character c = digits.charAt(index);
            Character[] chars = map.get(c);
            for (int i=0; i<chars.length; i++){
                stringBuffer.append(chars[i]);
                backtrack(map, res, digits, index+1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}

package Medium;

import java.util.*;

public class No49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str:strs){
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String sortedString = String.valueOf(array);
                List<String> li = map.getOrDefault(sortedString, new ArrayList<String>());
                li.add(str);
                map.put(sortedString, li);
            }
            return new ArrayList<>(map.values());
        }
    }
}

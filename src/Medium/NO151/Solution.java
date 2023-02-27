package Medium.NO151;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        Deque<String> words = new ArrayDeque<>();
        int len = s.length();
        for (int i=0; i<len; i++){
            char ch = s.charAt(i);
            if (ch!=' '){
                word.append(ch);
            }else if(word.length()!=0){
                words.push(word.toString());
                word.setLength(0);
            }
            if (i==len-1 && word.length()!=0){
                words.push(word.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (true){
            String cur = words.pop();
            res.append(cur);
            if (!words.isEmpty()) {
                res.append(' ');
            }else {
                break;
            }
        }
        return res.toString();
    }
}
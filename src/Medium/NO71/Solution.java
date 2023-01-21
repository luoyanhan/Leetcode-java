package Medium.NO71;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String s:arr){
            if (s.equals(".") || s.equals("/") || s.length()==0){
                continue;
            }else if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pollLast();
                }
            }else {
                stack.offerLast(s);
            }
        }
        StringBuilder answer = new StringBuilder();
        if (stack.isEmpty()){
            answer.append("/");
        }else {
            for (String s:stack){
                answer.append("/");
                answer.append(s);
            }
        }
        return answer.toString();
    }
}

package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class No71 {
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new ArrayDeque<>();
            String[] pathLi= path.split("/");
            for (String each:pathLi){
                if (each.equals("..")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }else if (!each.equals(".") && each.length()>0){
                    stack.push(each);
                }
            }
            StringBuilder res = new StringBuilder();
            if (stack.isEmpty()){
                res.append("/");
            }else {
                while (!stack.isEmpty()){
                    res.append("/");
                    res.append(stack.pollLast());
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args){
        No71 n = new No71();
        Solution s = n.new Solution();
        System.out.println(s.simplifyPath("/home/"));
    }
}

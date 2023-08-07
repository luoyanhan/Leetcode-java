package Medium.NO227;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int len = s.length();
        char preChar = '+';
        for (int i=0; i<len; i++){
            if (Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len-1){
                if (preChar == '+'){
                    stack.push(num);
                }else if (preChar == '-'){
                    stack.push(-num);
                }else if (preChar == '*'){
                    int preNum = stack.pop();
                    stack.push(preNum*num);
                }else {
                    int preNum = stack.pop();
                    stack.push(preNum/num);
                }
                num = 0;
                preChar = s.charAt(i);
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}

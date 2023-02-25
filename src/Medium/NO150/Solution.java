package Medium.NO150;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String word:tokens){
            if (word.equals("+") || word.equals("-") || word.equals("*") || word.equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (word.equals("+")){
                    stack.push(op1+op2);
                }else if (word.equals("-")){
                    stack.push(op1-op2);
                }else if (word.equals("*")){
                    stack.push(op1*op2);
                }else if (word.equals("/")){
                    stack.push(op1/op2);
                }
            }else {
                stack.push(Integer.parseInt(word));
            }
        }
        return stack.pop();
    }
}

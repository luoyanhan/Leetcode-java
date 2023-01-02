package Medium.NO22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList<String>();
        backtrack(answers, new StringBuilder(), 0, 0, n);
        return answers;
    }

    private void backtrack(List<String> answers, StringBuilder answer, int left, int right, int n){
        if (answer.length()==n*2){
            answers.add(answer.toString());
            return;
        }
        if (left<n){
            answer.append('(');
            backtrack(answers, answer, left+1, right, n);
            answer.deleteCharAt(answer.length()-1);
        }
        if (left>right){
            answer.append(')');
            backtrack(answers, answer, left, right+1, n);
            answer.deleteCharAt(answer.length()-1);
        }
    }
}

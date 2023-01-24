package Medium.NO77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        backTrack(answers, answer, 1, n, k);
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, int index, int n, int k){
        if (answer.size()==k){
            answers.add(new ArrayList<>(answer));
            return;
        }
        if (k-answer.size()>n-index+1){
            return;
        }
        backTrack(answers, answer, index+1, n, k);
        answer.add(index);
        backTrack(answers, answer, index+1, n, k);
        answer.remove(answer.size()-1);
    }
}

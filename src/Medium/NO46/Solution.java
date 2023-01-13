package Medium.NO46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        for (int num:nums){
            answer.add(num);
        }
        backTrack(answers, answer, 0);
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, int pos){
        if (pos==answer.size()){
            answers.add(new ArrayList<Integer>(answer));
        }
        for (int i=pos; i<answer.size(); i++){
            Collections.swap(answer, pos, i);
            backTrack(answers, answer, pos+1);
            Collections.swap(answer, pos, i);
        }
    }
}

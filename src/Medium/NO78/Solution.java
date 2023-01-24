package Medium.NO78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        int length = nums.length;
        for (int k=0; k<=length; k++){
            backTrack(answers, answer, nums, 0, length, k);
        }
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, int[] nums, int index, int length, int k){
        if (answer.size()==k){
            answers.add(new ArrayList<>(answer));
            return;
        }
        for (int i=index; i<length; i++){
            answer.add(nums[i]);
            backTrack(answers, answer, nums, i+1, length, k);
            answer.remove(answer.size()-1);
        }
    }
}

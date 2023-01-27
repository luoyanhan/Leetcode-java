package Medium.NO90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<int[]> records = new ArrayList<int[]>();
        for (int i=0; i<length; i++){
            int num = nums[i];
            if (records.isEmpty() || records.get(records.size()-1)[0]!=num){
                records.add(new int[]{num, 1});
            }else {
                records.get(records.size()-1)[1] += 1;
            }
        }
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        backTrack(answers, answer, records, 0);
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, List<int[]> records, int idx){
        if (idx==records.size()){
            answers.add(new ArrayList<>(answer));
            return;
        }
        backTrack(answers, answer, records, idx+1);
        int num = records.get(idx)[0];
        int cnt = records.get(idx)[1];
        for (int i=0; i<cnt; i++){
            answer.add(num);
            backTrack(answers, answer, records, idx+1);
        }
        for (int i=0; i<cnt; i++){
            answer.remove(answer.size()-1);
        }
    }
}

package Medium.NO47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        System.out.println(visited[0]);
        backTrack(answers, answer, nums, 0, visited);
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, int[] nums, int pos, boolean[] visited){
        if (pos==nums.length){
            answers.add(new ArrayList<>(answer));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])){
                continue;
            }
            visited[i] = true;
            answer.add(nums[i]);
            backTrack(answers, answer, nums, pos+1, visited);
            answer.remove(answer.size()-1);
            visited[i] = false;
        }
    }
}

package Medium.NO113;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> answer = new ArrayList<>();
        backTrack(answers, answer, root, 0, targetSum);
        return answers;
    }

    public void backTrack(List<List<Integer>> answers, List<Integer> answer, TreeNode node, int curSum, int targetSum){
        if (node==null){
            return;
        }
        answer.add(node.val);
        if (curSum+node.val==targetSum && node.left==null && node.right==null){
            answers.add(new ArrayList<>(answer));
        }
        backTrack(answers, answer, node.left, curSum+node.val, targetSum);
        backTrack(answers, answer, node.right, curSum+node.val, targetSum);
        answer.remove(answer.size()-1);
    }
}

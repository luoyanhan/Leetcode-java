package Medium.NO107;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (root==null){
            return answers;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> answer = new ArrayList<>();
            int num = queue.size();
            for (int i=0; i<num; i++){
                TreeNode cur = queue.poll();
                answer.add(cur.val);
                if (cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
            }
            answers.add(0, answer);
        }
        return answers;
    }
}

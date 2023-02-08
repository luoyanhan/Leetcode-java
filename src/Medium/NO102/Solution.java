package Medium.NO102;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if (root==null){
            return answers;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> answer = new ArrayList<>();
            int num = queue.size();
            for (int i=0; i<num; i++){
                TreeNode cur = queue.poll();
                answer.add(cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            answers.add(answer);
        }
        return answers;
    }
}

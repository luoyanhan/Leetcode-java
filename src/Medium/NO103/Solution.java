package Medium.NO103;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if (root==null){
            return answers;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 0;
        while (!queue.isEmpty()){
            Deque<Integer> answer = new LinkedList<>();
            int num = queue.size();
            for (int i=0; i<num; i++){
                TreeNode cur = queue.poll();
                if (floor%2==0){
                    answer.addLast(cur.val);
                }else {
                    answer.addFirst(cur.val);
                }
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            floor += 1;
            answers.add(new LinkedList<>(answer));
        }
        return answers;
    }
}

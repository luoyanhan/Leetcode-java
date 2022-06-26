package Medium;

import java.util.Deque;
import java.util.LinkedList;

public class No98 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
//    class Solution {
//        public boolean isValidBST(TreeNode root) {
//            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        }
//        public boolean dfs(TreeNode root, long low, long high){
//            if (root==null){
//                return true;
//            }
//            if (root.val<=low || root.val>=high){
//                return false;
//            }
//            return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
//        }
//    }
    class Solution {
        public boolean isValidBST(TreeNode root) {
            long preNum = Long.MIN_VALUE;
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root!=null){
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val<=preNum){
                    return false;
                }
                preNum = root.val;
                root = root.right;
            }
            return true;
        }
    }
}

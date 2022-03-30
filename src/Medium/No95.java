package Medium;

import java.util.LinkedList;
import java.util.List;

public class No95 {
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
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return dfs(1, n);
        }

        public List<TreeNode> dfs(int start, int end){
            List<TreeNode> res = new LinkedList<>();
            if (start>end){
                res.add(null);
                return res;
            }
            for (int root=start; root<=end; root++){
                List<TreeNode> leftTrees = dfs(start, root-1);
                List<TreeNode> rightTrees = dfs(root+1, end);
                for (TreeNode leftTree: leftTrees){
                    for (TreeNode rightTree:rightTrees){
                        TreeNode curNode = new TreeNode(root);
                        curNode.left = leftTree;
                        curNode.right = rightTree;
                        res.add(curNode);
                    }
                }
            }
            return res;
        }
    }
}

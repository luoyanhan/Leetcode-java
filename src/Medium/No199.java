package Medium;

import java.util.*;

public class No199 {
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
//        public List<Integer> rightSideView(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            if (root == null){
//                return res;
//            }
//            Map<Integer, Integer> depthValueMap = new HashMap<Integer, Integer>();
//            int maxDepth = -1;
//            Deque<Integer> depthStack = new ArrayDeque<Integer>();
//            Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
//            depthStack.push(0);
//            nodeStack.push(root);
//            while (!nodeStack.isEmpty()){
//                TreeNode node = nodeStack.pop();
//                int depth = depthStack.pop();
//                maxDepth = Math.max(maxDepth, depth);
//                if (!depthValueMap.containsKey(depth)){
//                    depthValueMap.put(depth, node.val);
//                }
//                if (node.left != null){
//                    depthStack.push(depth+1);
//                    nodeStack.push(node.left);
//                }
//                if (node.right != null){
//                    depthStack.push(depth+1);
//                    nodeStack.push(node.right);
//                }
//            }
//            for (int depth=0; depth<=maxDepth; depth++){
//                res.add(depthValueMap.get(depth));
//            }
//            return res;
//        }
//    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null){
                return res;
            }
            Map<Integer, Integer> depthValueMap = new HashMap<Integer, Integer>();
            int maxDepth = -1;
            Queue<Integer> depthQueue = new ArrayDeque<Integer>();
            Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
            depthQueue.add(0);
            nodeQueue.add(root);
            while (!nodeQueue.isEmpty()){
                TreeNode node = nodeQueue.remove();
                int depth = depthQueue.remove();
                maxDepth = Math.max(depth, maxDepth);
                depthValueMap.put(depth, node.val);
                if (node.left!=null){
                    nodeQueue.add(node.left);
                    depthQueue.add(depth+1);
                }
                if (node.right!=null){
                    nodeQueue.add(node.right);
                    depthQueue.add(depth+1);
                }
            }
            for (int depth=0; depth<=maxDepth; depth++){
                res.add(depthValueMap.get(depth));
            }
            return res;
        }
    }
}

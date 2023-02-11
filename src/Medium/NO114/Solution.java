package Medium.NO114;

import java.util.ArrayDeque;
import java.util.Deque;

//class Solution {
//    public void flatten(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        if (root!=null){
//            stack.push(root);
//            TreeNode preNode = null;
//            recursion(stack, null);
//        }
//    }
//
//    public void recursion(Deque<TreeNode> stack, TreeNode preNode){
//        while (!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if (node.right!=null) {
//                stack.push(node.right);
//            }
//            if (node.left!=null) {
//                stack.push(node.left);
//            }
//            if (preNode!=null){
//                preNode.right = node;
//                preNode.left = null;
//            }
//            preNode = node;
//        }
//    }
//}

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curNode = root;
        while (curNode!=null){
            if (curNode.left!=null){
                TreeNode next = curNode.left;
                TreeNode preNode = next;
                while (preNode.right!=null){
                    preNode = preNode.right;
                }
                preNode.right = curNode.right;
                curNode.left = null;
                curNode.right = next;
            }
            curNode = curNode.right;
        }
    }
}

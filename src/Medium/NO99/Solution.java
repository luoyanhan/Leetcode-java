package Medium.NO99;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode first=null, second=null, pred=null;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred!=null && pred.val>root.val){
                second = root;
                if (first==null){
                    first = pred;
                }else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

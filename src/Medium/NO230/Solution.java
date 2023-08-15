package Medium.NO230;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k==0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

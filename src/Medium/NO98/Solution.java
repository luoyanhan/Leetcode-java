package Medium.NO98;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBinNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBinNode(TreeNode node, long min, long max){
        if (node==null){
            return true;
        }
        if (node.val>=max || node.val<=min){
            return false;
        }
        return isBinNode(node.left, min, node.val) && isBinNode(node.right, node.val, max);
    }
}

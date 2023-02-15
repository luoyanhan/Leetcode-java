package Medium.NO129;


class Solution {
    public int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    public int recursion(TreeNode node, int sum){
        sum = sum*10 + node.val;
        if (node.left==null && node.right==null){
            return sum;
        }else {
            int leftSum = node.left!=null?recursion(node.left, sum):0;
            int rightSum = node.right!=null?recursion(node.right, sum):0;
            return leftSum+rightSum;
        }
    }
}

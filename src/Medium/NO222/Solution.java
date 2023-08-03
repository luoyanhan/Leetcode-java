package Medium.NO222;


class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int height = 0;
        TreeNode node = root;
        while (node.left != null){
            height += 1;
            node = node.left;
        }
        int left = 1 << height;
        int right = (1 << (height+1)) - 1;
        while (left < right){
            int mid = left + (right-left+1)/2;
            if (isExist(root, height, mid)){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    public boolean isExist(TreeNode root, int height, int num){
        int bit = 1 << (height-1);
        TreeNode node = root;
        while (node != null && bit>0){
            if ((num&bit) == 0){
                node = node.left;
            }else {
                node = node.right;
            }
            bit >>= 1;
        }
        return node!=null;
    }
}

package Medium.NO105;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx=0; idx<inorder.length; idx++){
            map.put(inorder[idx], idx);
        }
        int num = preorder.length;
        return recursion(map, preorder, inorder, 0, num-1, 0, num-1);
    }

    public TreeNode recursion(Map<Integer, Integer> map, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft>preRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIdx = map.get(rootVal);
        int numOfLeftNode = rootInorderIdx - inLeft;
        root.left = recursion(map, preorder, inorder, preLeft+1, preLeft+numOfLeftNode, inLeft, rootInorderIdx-1);
        root.right = recursion(map, preorder, inorder, preLeft+numOfLeftNode+1, preRight, rootInorderIdx+1, inRight);
        return root;
    }
}

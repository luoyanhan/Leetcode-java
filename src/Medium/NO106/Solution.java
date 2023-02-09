package Medium.NO106;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = inorder.length;
        for (int i=0; i<len; i++){
            map.put(inorder[i], i);
        }
        return recursion(map, inorder, postorder, 0, len-1, 0, len-1);
    }

    public TreeNode recursion( Map<Integer, Integer> map, int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight){
        if (inLeft>inRight){
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int inIdx = map.get(rootVal);
        int numOfLeftNode = inIdx - inLeft;
        root.left = recursion(map, inorder, postorder, inLeft, inIdx-1, postLeft, postLeft+numOfLeftNode-1);
        root.right = recursion(map, inorder, postorder, inIdx+1, inRight, postLeft+numOfLeftNode, postRight-1);
        return root;
    }
}

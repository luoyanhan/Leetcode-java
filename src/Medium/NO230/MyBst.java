package Medium.NO230;

import java.util.HashMap;

public class MyBst {
    TreeNode root;
    HashMap<TreeNode, Integer> map;

    public MyBst(TreeNode root){
        this.root = root;
        this.map = new HashMap<TreeNode, Integer>();
        CountNoneNum(root);
    }

    public int CountNoneNum(TreeNode root){
        if (root==null){
            return 0;
        }
        map.put(root, 1+CountNoneNum(root.left)+CountNoneNum(root.right));
        return map.get(root);
    }

    public int GetkthSmallest(int k){
        TreeNode node = root;
        while (node != null){
            int LeftNum = map.getOrDefault(node.left, 0);
            if (LeftNum<k-1){
                node = node.right;
                k = k - LeftNum - 1;
            }else if (LeftNum == k-1){
                break;
            }else {
                node = node.left;
            }
        }
        return node.val;
    }
}

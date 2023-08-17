package Medium.NO235;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> Fathers1 = new ArrayList<>();
        TreeNode node = root;
        while (node!=null) {
            Fathers1.add(node);
            if (node.val == p.val) {
                break;
            } else if (p.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        TreeNode res = root;
        TreeNode nextNode = null;
        int idx = 0;
        while (idx<Fathers1.size()-1){
            nextNode = Fathers1.get(idx+1);
            if (res.val==q.val){
                break;
            }else if (q.val<res.val){
                res = res.left;
            }else {
                res = res.right;
            }
            if (res!=nextNode){
                res = Fathers1.get(idx);
                break;
            }
            idx++;
        }
        return res;
    }
}


//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        TreeNode ptr1 = root, ptr2 = root, res = root;
//        while (ptr1!=null && ptr2!=null){
//            if (ptr1.val==p.val){
//                return ptr1;
//            }
//            if (ptr2.val==q.val){
//                return ptr2;
//            }
//
//            if (p.val<ptr1.val){
//                ptr1=ptr1.left;
//            }else {
//                ptr1=ptr1.right;
//            }
//            if (q.val<ptr2.val){
//                ptr2=ptr2.left;
//            }else {
//                ptr2=ptr2.right;
//            }
//            if (ptr1.val==ptr2.val){
//                res = ptr1;
//            }else {
//                break;
//            }
//        }
//        return res;
//    }
//}

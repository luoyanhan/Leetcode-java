package Medium.NO235;

import java.util.ArrayList;
import java.util.List;

//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> Fathers1 = new ArrayList<>();
//        TreeNode node = root;
//        while (node!=null) {
//            Fathers1.add(node);
//            if (node.val == p.val) {
//                break;
//            } else if (p.val < node.val) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        node = root;
//        int idx = 0;
//        while (node!=null){
//            if (idx==Fathers1.size()){
//                break;
//            }
//            if (node.val!=Fathers1.get(idx).val){
//                break;
//            }
//            if (q.val==Fathers1.get(idx).val){
//                idx++;
//                break;
//            }
//            if (q.val<node.val){
//                node = node.left;
//            }else {
//                node = node.right;
//            }
//            idx++;
//        }
//        return Fathers1.get(idx-1);
//    }
//}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr1 = root, ptr2 = root, res = root;
        while (ptr1!=null && ptr2!=null){
            if (ptr1.val==p.val){
                return ptr1;
            }
            if (ptr2.val==q.val){
                return ptr2;
            }

            if (p.val<ptr1.val){
                ptr1=ptr1.left;
            }else {
                ptr1=ptr1.right;
            }
            if (q.val<ptr2.val){
                ptr2=ptr2.left;
            }else {
                ptr2=ptr2.right;
            }
            if (ptr1.val==ptr2.val){
                res = ptr1;
            }else {
                break;
            }
        }
        return res;
    }
}

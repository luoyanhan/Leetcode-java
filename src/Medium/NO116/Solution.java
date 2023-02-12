package Medium.NO116;

import java.util.ArrayDeque;
import java.util.Queue;

//class Solution {
//    public Node connect(Node root) {
//        if (root==null){
//            return root;
//        }
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//        Node preNode = null;
//        while (!queue.isEmpty()){
//            int num = queue.size();
//            for (int i=0; i<num; i++) {
//                Node curNode = queue.poll();
//                if (curNode.left!=null){
//                    queue.add(curNode.left);
//                }
//                if (curNode.right!=null){
//                    queue.add(curNode.right);
//                }
//                if (preNode!=null){
//                    preNode.next = curNode;
//                }
//                preNode = curNode;
//            }
//            preNode = null;
//        }
//        return root;
//    }
//}

class Solution {
    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        Node letMost = root;
        while (letMost!=null) {
            Node cur = letMost;
            while (cur!=null && cur.left!=null){
                cur.left.next = cur.right;
                if (cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            letMost = letMost.left;
        }
        return root;
    }
}

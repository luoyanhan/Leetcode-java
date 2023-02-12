package Medium.NO117;

class Solution {
    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        Node cur = root;
        while (cur!=null) {
            Node dummy = new Node();
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}

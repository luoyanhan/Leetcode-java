package Medium.NO109;


class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return recursion(head, null);
    }

    public TreeNode recursion(ListNode left, ListNode right){
        if (left==right){
            return null;
        }
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = recursion(left, mid);
        root.right = recursion(mid.next, right);
        return root;
    }

    public ListNode getMidNode(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while (fast!=right && fast.next!=right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

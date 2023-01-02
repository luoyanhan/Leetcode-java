package Medium.NO24;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(), cur;
        dummy.next = head;
        cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            ListNode left = cur.next, right = cur.next.next;
            cur.next = right;
            left.next = right.next;
            right.next = left;
            cur = left;
        }
        return dummy.next;
    }
}

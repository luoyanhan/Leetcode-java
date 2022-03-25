package Medium;

public class No92 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            for (int i=0; i<left-1; i++){
                cur = cur.next;
            }
            head = cur;
            cur = cur.next;
            ListNode next;
            for (int i=0; i<right-left; i++){
                next = cur.next;
                cur.next = next.next;
                next.next = head.next;
                head.next = next;
            }
            return dummy.next;
        }
    }
}

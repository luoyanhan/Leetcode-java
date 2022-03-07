package Medium;

public class No61 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            ListNode cur = head;
            ListNode tail = null;
            if (cur==null || cur.next==null){
                return head;
            }
            int length = 1;
            while (cur.next!=null){
                length++;
                cur = cur.next;
                if (cur.next==null){
                    tail = cur;
                }
            }
            int location = k % length;
            cur = head;
            for (int i=1; i<length-location; i++){
                cur=cur.next;
            }
            tail.next = head;
            head = cur.next;
            cur.next = null;
            return head;
        }
    }
}

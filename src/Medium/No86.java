package Medium;

public class No86 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smaller = new ListNode(0);
            ListNode curSmaller = smaller;
            ListNode bigger = new ListNode(0);
            ListNode curBigger = bigger;
            ListNode cur = head;
            while (cur!=null){
                if (cur.val<x){
                    curSmaller.next = cur;
                    curSmaller = curSmaller.next;
                }else {
                    curBigger.next = cur;
                    curBigger = curBigger.next;
                }
                cur = cur.next;
            }
            curSmaller.next = bigger.next;
            curBigger.next = null;
            return smaller.next;
        }
    }
}

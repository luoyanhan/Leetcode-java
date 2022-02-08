package Medium;

public class No24 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
//    class Solution {
//        public ListNode swapPairs(ListNode head) {
//            ListNode dummy = new ListNode(0, head);
//            ListNode tmp = dummy;
//            while (tmp.next!=null && tmp.next.next!=null){
//                ListNode node1 = tmp.next, node2=tmp.next.next;
//                node1.next = node2.next;
//                node2.next = node1;
//                tmp.next = node2;
//                tmp = node1;
//            }
//            return dummy.next;
//        }
//    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head==null || head.next==null){
                return head;
            }
            ListNode newHead=head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }
}

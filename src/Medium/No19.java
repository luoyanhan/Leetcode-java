package Medium;

import java.util.Deque;
import java.util.LinkedList;

public class No19 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
//    class Solution {
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            ListNode dummy = new ListNode(0, head);
//            Deque<ListNode> stack = new LinkedList<>();
//            ListNode cur = dummy;
//            while (cur!=null){
//                stack.push(cur);
//                cur = cur.next;
//            }
//            for (int i=0; i<n; i++){
//                stack.pop();
//            }
//            ListNode top = stack.peek();
//            top.next = top.next.next;
//            return dummy.next;
//        }
//    }
//    class Solution {
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            int len = 0;
//            ListNode dummy = new ListNode(0, head);
//            ListNode cur = dummy;
//            while (cur!=null){
//                len++;
//                cur=cur.next;
//            }
//            cur = dummy;
//            for (int i=0; i<len-n-1; i++){
//                cur=cur.next;
//            }
//            cur.next = cur.next.next;
//            return dummy.next;
//        }
//    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode left=dummy, right=dummy;
            for (int i=0; i<n+1; i++){
                right = right.next;
            }
            while (right!=null){
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
            return dummy.next;
        }
    }
}

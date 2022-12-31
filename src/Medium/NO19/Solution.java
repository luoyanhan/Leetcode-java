package Medium.NO19;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode cur = dummy;
//        int len = 0;
//        while (cur != null){
//            cur = cur.next;
//            len++;
//        }
//        int i = 0;
//        cur = dummy;
//        while (i<len-n-1){
//            cur = cur.next;
//            i++;
//        }
//        cur.next = cur.next.next;
//        return dummy.next;
//    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Deque<ListNode> stack = new LinkedList<ListNode>();
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode cur = dummy;
//        while (cur != null){
//            stack.push(cur);
//            cur = cur.next;
//        }
//        for (int i=0; i<n+1; i++){
//            cur = stack.pop();
//        }
//        System.out.println(cur.val);
//        cur.next = cur.next.next;
//        return dummy.next;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy, right = dummy;
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

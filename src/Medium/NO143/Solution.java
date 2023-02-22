package Medium.NO143;

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow!=head){
            ListNode cur = slow.next;
            slow.next = null;
            ListNode pre = null;
            ListNode next = null;
            while (cur!=null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode secondHead = pre;
            ListNode firstHead = head;
            while (secondHead!=null){
                next = firstHead.next;
                firstHead.next = secondHead;
                secondHead = secondHead.next;
                firstHead.next.next = next;
                firstHead = next;
            }
        }
    }
}

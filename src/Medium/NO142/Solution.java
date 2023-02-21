package Medium.NO142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast.next==null||fast.next.next==null){
                return null;
            }else {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
        }
        ListNode ptr = head;
        while (ptr!=slow){
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}

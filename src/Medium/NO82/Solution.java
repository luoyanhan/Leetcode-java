package Medium.NO82;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.val==cur.next.val){
                int val = cur.val;
                while (cur!=null && cur.val==val){
                    cur=cur.next;
                }
                pre.next = cur;
            }
            else {
                cur=cur.next;
                pre=pre.next;
            }
        }
        return dummy.next;
    }
}

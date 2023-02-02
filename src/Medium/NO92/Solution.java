package Medium.NO92;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null || left==right){
            return head;
        }
        ListNode dummyHead = new ListNode(), leftPre = new ListNode(), rightNext = new ListNode(), cur = dummyHead, curNext, betweenTail = new ListNode();
        dummyHead.next = head;
        for (int i=0; i<=right; i++){
            if (i==left-1){
                leftPre = cur;
                cur = cur.next;
                betweenTail = cur;
                leftPre.next = null;
            }else if (i>=left && i<right){
                curNext = cur.next;
                cur.next = leftPre.next;
                leftPre.next = cur;
                cur = curNext;
            }else if (i==right){
                rightNext = cur.next;
                cur.next = leftPre.next;
                leftPre.next = cur;
            }else {
                cur = cur.next;
            }
        }
        betweenTail.next = rightNext;
        return dummyHead.next;
    }
}

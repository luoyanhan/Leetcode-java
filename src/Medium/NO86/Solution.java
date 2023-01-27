package Medium.NO86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode dummyBigger = new ListNode(), biggerTail = dummyBigger, dummySmaller = new ListNode(), smallerTail = dummySmaller;
        ListNode cur = head;
        while (cur!=null){
            if (cur.val<x){
                smallerTail.next = cur;
                cur = cur.next;
                smallerTail = smallerTail.next;
                smallerTail.next = null;
            }else {
                biggerTail.next = cur;
                cur = cur.next;
                biggerTail = biggerTail.next;
                biggerTail.next = null;
            }
        }
        smallerTail.next = dummyBigger.next;
        dummyBigger.next = null;
        return dummySmaller.next;
    }
}

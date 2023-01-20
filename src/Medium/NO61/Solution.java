package Medium.NO61;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null || k==0){
            return head;
        }
        int length = 1;
        ListNode pos;
        pos = head;
        while (pos.next!=null){
            pos=pos.next;
            length++;
        }
        if (k%length==0){
            return head;
        }
        pos.next = head;
        pos = head;
        for (int i=0; i<length-(k%length)-1; i++){
            pos=pos.next;
        }
        head = pos.next;
        pos.next = null;
        return head;
    }
}

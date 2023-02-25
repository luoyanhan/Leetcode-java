package Medium.NO148;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode cur = head;
        int lenOfList = 1;
        while (cur.next!=null){
            cur = cur.next;
            lenOfList++;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        for (int lenThisTime = 1; lenThisTime<=lenOfList; lenThisTime*=2){
            cur = dummyHead.next;
            ListNode pre = dummyHead;
            while (cur!=null){
                ListNode head1 = cur;
                for (int i=1; i<lenThisTime&&cur.next!=null; i++){
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i=1; i<lenThisTime&&cur!=null&&cur.next!=null; i++){
                    cur = cur.next;
                }
                ListNode nextHead = null;
                if (cur!=null) {
                    nextHead = cur.next;
                    cur.next = null;
                }
                ListNode mergedNode = merge(head1, head2);
                pre.next = mergedNode;
                while (pre.next!=null){
                    pre = pre.next;
                }
                pre.next = nextHead;
                cur = nextHead;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (head1!=null && head2!=null){
            if (head1.val<=head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1!=null){
            cur.next = head1;
        }
        if (head2!=null){
            cur.next = head2;
        }
        return dummyHead.next;
    }
}

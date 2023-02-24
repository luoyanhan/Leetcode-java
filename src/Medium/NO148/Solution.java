package Medium.NO148;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head;
        int length = 1;
        while (cur.next!=null){
            cur = cur.next;
            length++;
        }
        for (int curLength=1; curLength<=length; curLength*=2){
            ListNode pre = dummyHead;
            cur = dummyHead.next;
            while (cur!=null){
                ListNode head1 = cur;
                for (int i=1; i<curLength && cur.next!=null; i++){
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i=1; i<curLength && cur!=null && cur.next!=null; i++){
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur!=null){
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next!=null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while (node1!=null && node2!=null){
            if (node1.val<=node2.val){
                temp.next = node1;
                node1 = node1.next;
            }else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1!=null){
            temp.next = node1;
        }
        if (node2!=null){
            temp.next = node2;
        }
        return dummyHead.next;
    }
}

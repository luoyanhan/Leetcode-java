package Medium.NO2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int num1 = l1!=null ? l1.val : 0;
            int num2 = l2!=null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum / 10;
            if (head==null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = tail.next;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry>0){
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }
}

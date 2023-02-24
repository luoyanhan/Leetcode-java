package Medium.NO147;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode prepareSort = head.next;
        while (prepareSort!=null){
            if (prepareSort.val>=lastSorted.val){
                lastSorted = prepareSort;
                prepareSort = prepareSort.next;
            }else {
                ListNode insertPos = dummyHead;
                while (insertPos.next.val<prepareSort.val){
                    insertPos = insertPos.next;
                }
                lastSorted.next = prepareSort.next;
                prepareSort.next = insertPos.next;
                insertPos.next = prepareSort;
                prepareSort = lastSorted.next;
            }
        }
        return dummyHead.next;
    }
}

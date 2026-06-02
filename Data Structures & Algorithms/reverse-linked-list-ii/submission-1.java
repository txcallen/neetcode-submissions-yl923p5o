/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        for(int i = 0; i < left-1; i++){
            pre = pre.next;
        }

        ListNode subListHead = pre.next;
        ListNode subListTail = subListHead;

        for(int i = 0; i < right - left; i++){
            subListTail = subListTail.next;
        }

        ListNode next = subListTail.next;
        subListTail.next = null;
        pre.next = reverse(subListHead);
        subListHead.next = next;

        return dummy.next;

    }

    ListNode reverse(ListNode node){
        ListNode pre = null;

        while(node != null){
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }

        return pre;
    }
}
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
    private ListNode after;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = head;
        ListNode curr = head;
        after = null;
        int index = 1;
        while(curr != null){
            if(left == 1 && index == left){
                res = reverse(head, left, right);
                curr = res.next;
            }
            else if(index + 1 == left){
                curr.next = reverse(curr.next, left, right);
                curr = curr.next;
            }
            else if(index == right){
                curr.next = after;
                curr = curr.next;
            }
            else{
                curr = curr.next;
            }
            index++;
        }
        return res;
    }

    public ListNode reverse(ListNode head, int curr, int end){
        if(curr == end){
            after = head.next;
            return head;
        }
        ListNode newHead = head;
        if(curr + 1 <= end && head.next != null){
            newHead = reverse(head.next, curr + 1, end);
            head.next.next = head;
        }
        head.next = null;
        return newHead;

    }
}
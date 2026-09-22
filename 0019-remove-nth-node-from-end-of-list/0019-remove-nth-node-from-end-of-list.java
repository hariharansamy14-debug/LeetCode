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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
		int size =0;
		while(temp!=null) {
			size++;
			temp = temp.next;
		}
      if(size == n){
        return head.next;
      }

		int s = 1;
		int finaln  = size - n;
		ListNode curr = head;
		while(curr!=null && s!=finaln) {
			s++;
			curr= curr.next;
		}
		curr.next = curr.next.next;
        return head;
    }
}
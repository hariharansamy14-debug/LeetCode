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
    public ListNode middleNode(ListNode head) {
 ListNode temp = head ;
	     int count =1 ;
	     while(temp.next!=null){
	         count +=1;
	         temp = temp.next;
	     }
	     int index = count/2;

	     int s=0;
	     ListNode curr = head;
	  while (curr!=null){
	    
	    if(curr!=null && s >= index){
	    
	            return curr;
	    }
	     s++;

	     curr = curr.next;
	  }
	  
	  return curr;
}
}
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
        //if(head.next==null && n==1)return new ListNode();
        int l=0;
        ListNode curr=head,temp=head;;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        
        int x=l-n;
        ListNode prev=head;
        curr=head;
        if(l==n)return curr.next;
        while(x>0){
            prev=curr;
            curr=curr.next;
            x--;
        }
        prev.next=curr.next;
        return temp;

    }
}
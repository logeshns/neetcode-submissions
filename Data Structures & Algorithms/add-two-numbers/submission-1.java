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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        ListNode temp1=l1,temp2=l2;
        int rem=0;
        while(temp1!=null && temp2!=null){
            int currSum=temp1.val+temp2.val+rem;
            rem=currSum/10;
            curr.next=new ListNode(currSum%10);
            curr=curr.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp1==null){
            while(temp2!=null){
                int currSum=temp2.val+rem;
                rem=currSum/10;
                curr.next=new ListNode(currSum%10);
                curr=curr.next;
                temp2=temp2.next;
            }
        }else{
            while(temp1!=null){
                int currSum=temp1.val+rem;
                rem=currSum/10;
                curr.next=new ListNode(currSum%10);
                curr=curr.next;
                temp1=temp1.next;
            }
        }
        if(rem!=0){
            curr.next=new ListNode(rem);
        }
        return dummy.next;
    }
}
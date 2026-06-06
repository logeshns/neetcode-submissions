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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy,pt1=list1,pt2=list2;
        while(pt1!=null && pt2 != null){
           if(pt1.val<pt2.val){
            curr.next=pt1;
            pt1=pt1.next;
           }else{
            curr.next=pt2;
            pt2=pt2.next;
           }
           curr=curr.next;
           
        }
        if(pt1!=null)curr.next=pt1;
        if(pt2!=null)curr.next=pt2;
        return dummy.next;
    }
}
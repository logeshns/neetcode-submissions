/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count=0,answer=0;
    public void helper(TreeNode root,int k){
        if(root==null)return;
        helper(root.left,k);
        count++;
        if(count==k){
            answer=root.val;
            return;
        }
        helper(root.right,k);

    }
    public int kthSmallest(TreeNode root, int k) {
        //ArrayList<Integer> arr=new ArrayList<>();
         helper(root,k);
         return answer;
       

    }
}

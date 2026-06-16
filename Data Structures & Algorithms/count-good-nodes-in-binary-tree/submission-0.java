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
    int ans=0;
    public void helper(TreeNode root,int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            ans++;
            max=root.val;
        }
        helper(root.left,Math.max(max,root.val));
        helper(root.right,Math.max(max,root.val));
        return;
    }
    public int goodNodes(TreeNode root) {
        helper(root,root.val);
        return ans;
    }
}

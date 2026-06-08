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
    public boolean isBalanced(TreeNode root) {
       if(check(root)==-1)return false;
       return true; 
    }
    public int check(TreeNode node){
        if(node==null){
            return 0;
        }
        int lef=check(node.left);
        int righ=check(node.right);
        if(lef==-1 || righ==-1)return -1;
        if(Math.abs(lef-righ)>1)return -1;
        return Math.max(lef,righ)+1;
    }
}

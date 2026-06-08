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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p,q);
    }
    public boolean check(TreeNode x,TreeNode y){
        if(x==null && y!=null)return false;
        if(x!=null && y==null)return false;
        if(x==null && y==null){
            return true;
        }
        if(x.val != y.val){
            return false;
        }
        return check(x.left,y.left)&& check(x.right,y.right);
        
    }
}

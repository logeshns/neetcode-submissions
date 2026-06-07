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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diam(root);
        return diameter-1;
    }
    public int diam(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight=diam(node.left);
        int rightHeight=diam(node.right);
        int dia=leftHeight+rightHeight+1;
        diameter=Math.max(dia,diameter);
        return Math.max(leftHeight,rightHeight)+1;
    }

}

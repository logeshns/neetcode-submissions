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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        if(root==null)return ll;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode q=queue.poll();
                if(i==levelSize-1)ll.add(q.val);
                if(q.left != null) queue.add(q.left);
                if(q.right != null) queue.add(q.right);
            }
        }
        return ll;
    }
}

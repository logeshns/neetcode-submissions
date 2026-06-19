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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i=0;i<queue.size();i++){
                TreeNode x=queue.poll();
                if(x!=null){
                    sb.append(x.val+" ");
                    queue.add(x.left);
                    queue.add(x.right);
                }else{
                    sb.append("n ");
                }
            }

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        Queue<TreeNode> queue=new LinkedList<>();
        String[] arr=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode parent=queue.poll();
            if(!arr[i].equals("n")){
                TreeNode lef=new TreeNode(Integer.parseInt(arr[i]));
                queue.add(lef);
                parent.left=lef;
            }
            if(!arr[++i].equals("n")){
                TreeNode righ=new TreeNode(Integer.parseInt(arr[i]));
                queue.add(righ);
                parent.right=righ;
            }
        }
        return root;

    }
}

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        find(root, val);

        return root;
    }

    void find(TreeNode node, int val){

        if(node == null){
            return;
        }


        if(node.val > val){
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                find(node.left, val);
            }
            
        }else{
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                find(node.right, val);
            }
        }
    }
}
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        if(root == null){
            return null;
        }

        return delete(root, target);
    }


    TreeNode delete(TreeNode node, int target){
        if(node == null){
            return null;
        }

        if(node.left != null){
            node.left = delete(node.left, target);
        }

        if(node.right != null){
            node.right = delete(node.right, target);
        }

        if(node.left == null && node.right == null && node.val == target){
            return null;
        }else{
            return node;
        }
    }
}
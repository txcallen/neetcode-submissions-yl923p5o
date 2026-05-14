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
    Map<Integer, Integer> rootIdx = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            rootIdx.put(inorder[i], i);
        }

        return buildTree(0, inorder.length-1, preorder, inorder);
    }

    TreeNode buildTree(int l, int r, int[] preorder, int[] inorder){
        if(l > r){
            return null;
        }
        int rootVal = preorder[preIdx++];
        TreeNode node = new TreeNode(rootVal);
        int idx = rootIdx.get(rootVal);
    
        node.left = buildTree(l, idx-1, preorder, inorder);
        node.right = buildTree(idx+1, r, preorder, inorder);

        return node;
    }  
}   

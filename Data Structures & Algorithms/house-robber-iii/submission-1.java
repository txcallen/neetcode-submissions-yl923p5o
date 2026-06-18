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

    int max = 0;

    Map<TreeNode, Integer> vals = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }    

        if(vals.containsKey(root)){
            return vals.get(root);
        }

        int cur = root.val;

        if(root.left != null){
            cur += rob(root.left.left) + rob(root.left.right);    
        }

        if(root.right != null){
            cur += rob(root.right.left) + rob(root.right.right);
        }

        max = Math.max(cur, rob(root.left) + rob(root.right));

        vals.put(root, max);

        return max;
    }
}
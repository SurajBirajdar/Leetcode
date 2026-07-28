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

    boolean solve(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null ) {
            if(targetSum == root.val) {
                return true;
        } else return false;
    }
    return hasPathSum(root.left, targetSum - root.val) ||  hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return solve(root, targetSum);
        
       
    }
}
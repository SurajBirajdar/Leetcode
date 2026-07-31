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

    static void solve(TreeNode root, List<Integer> output, List<String> ans) {
        if(root == null) return;
        output.add(root.val);
        if(root.left == null && root.right == null) {

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<output.size(); i++) {
                sb.append(output.get(i));
                if(i != output.size()-1) {
                    sb.append("->");
                }
            }
            ans.add(sb.toString());


        }
        solve(root.left, output, ans);
        solve(root.right, output, ans);
        output.remove(output.size()-1);
    }
           
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(root, output, ans);
        return ans;
    }
}
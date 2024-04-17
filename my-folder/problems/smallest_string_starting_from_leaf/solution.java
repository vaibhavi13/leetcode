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
    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {

        dfs(root, new StringBuilder());
        return ans;      
    }

    private void dfs(TreeNode node, StringBuilder sb){

        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            char c = (char) (node.val + 'a');
            sb.append(c);
            if((sb.reverse().toString()).compareTo(ans) < 0){
                ans = sb.toString();
            }
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        char c = (char) (node.val + 'a');
        sb.append(c);

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
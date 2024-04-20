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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null){
            return 0;
        }

        findGain(root);

        return max;
        
    }

    private int findGain(TreeNode node){

        if(node == null){
            return 0;
        }

        int leftGain = Math.max(findGain(node.left), 0);
        int rightGain = Math.max(findGain(node.right), 0);

        max = Math.max(max , leftGain + rightGain + node.val);

        return Math.max(leftGain + node.val , rightGain + node.val);
    }
}
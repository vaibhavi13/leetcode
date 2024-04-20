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
    HashMap<Integer,Integer> map;
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // preOrder -> 3 9 20 15 7
        // inorder -> 9 3 15 20 7

        map = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, map);
       
    }

    private TreeNode helper(int[] preorder, int left, int right, HashMap<Integer,Integer> map){

       if(left > right){
          return null;
       }

       int rootVal = preorder[preorderIndex++];

       TreeNode root = new TreeNode(rootVal);

       root.left = helper(preorder, left, map.get(rootVal) - 1, map);
       root.right = helper(preorder, map.get(rootVal) + 1, right, map);

       return root;
    }
}
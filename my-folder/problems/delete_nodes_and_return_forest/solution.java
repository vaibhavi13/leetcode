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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

           List<TreeNode> forest = new ArrayList<>();

           HashSet<Integer> set = new HashSet<>();

           for(int d : to_delete){
            set.add(d);
           }

           Queue<TreeNode> queue = new LinkedList<>();
           queue.add(root);

           while(!queue.isEmpty()){
                TreeNode curr = queue.poll();

                if(curr.left != null){
                    queue.add(curr.left);

                    if(set.contains(curr.left.val)){
                        curr.left = null;
                    }
                }

                if(curr.right != null){
                     queue.add(curr.right);

                     if(set.contains(curr.right.val)){
                        curr.right = null;
                     }
                }

                if(set.contains(curr.val)){
                    if(curr.left != null){
                        forest.add(curr.left);
                    }

                    if(curr.right != null){
                        forest.add(curr.right);
                    }
                }
           }

           if(!set.contains(root.val)){
            forest.add(root);
           }

           return forest;

        
    }
}
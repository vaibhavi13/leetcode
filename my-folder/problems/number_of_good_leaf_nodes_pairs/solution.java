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
    public int countPairs(TreeNode root, int distance) {
        
        HashMap<TreeNode,List<TreeNode>> map = new HashMap<>();

        HashSet<TreeNode> leaf = new HashSet<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr.left == null && curr.right == null){
               leaf.add(curr);
            }

            if(curr.left != null){
                queue.add(curr.left);
                map.putIfAbsent(curr,new ArrayList<>());
                map.get(curr).add(curr.left);
                map.putIfAbsent(curr.left,new ArrayList<>());
                map.get(curr.left).add(curr);
            }

            if(curr.right != null){
                queue.add(curr.right);
                map.putIfAbsent(curr, new ArrayList<>());
                map.get(curr).add(curr.right);
                map.putIfAbsent(curr.right, new ArrayList<>());
                map.get(curr.right).add(curr);
            }        
        }

        List<TreeNode> list = new ArrayList<>();
        list.addAll(leaf); 
        int count = 0;
        for(TreeNode curr : list){

            queue = new LinkedList<>();
            HashSet<TreeNode> visited = new HashSet<>();

            queue.add(curr);
            visited.add(curr);


            for(int l = 0 ; l <= distance ; l++){

                int size = queue.size();
                
                for(int i = 0 ; i < size ; i++){

                    TreeNode top = queue.poll();

                    if(leaf.contains(top) && top != curr ){
                        count++;
                    }

                // System.out.println(" neighbors of " + top.val + " are " + map.getOrDefault(top, new ArrayList<>()) + " in level : " + level + " and count is " + count);
                    for(TreeNode m : map.getOrDefault(top, new ArrayList<>())){
                        if(!visited.contains(m)){
                            visited.add(m);
                            queue.add(m);
                        }
                    }
                }
            }


        //System.out.println("for " + curr + " count is " + count);

        }


        return count/2;
    }

    private int find(TreeNode curr, List<TreeNode> leaves , HashMap<TreeNode,List<TreeNode>> map, int distance){
        
       // System.out.println(leaves.toString());
        int count = 0;
        
        return count;
    }
}
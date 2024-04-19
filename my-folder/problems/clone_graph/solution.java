/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }
        

        Node newHead = new Node(node.val);
        Node temp = newHead;

        Queue<Pair<Node,Node>> queue = new LinkedList<>();
        queue.add(new Pair<>(node,temp));
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node, temp);

        while(queue.size() > 0){
            Pair<Node,Node> pair = queue.poll();
            Node givenNode = pair.getKey();
            Node newNode = pair.getValue();
      
            List<Node> givenNeigh = givenNode.neighbors;
        
            if(givenNeigh.size() > 0){
                List<Node> newNodeList = new ArrayList<>();

                for(Node given : givenNeigh){
                    if(!map.containsKey(given)){
                        Node newN = new Node(given.val);
                        map.put(given, newN);
                        queue.add(new Pair<>(given,newN));
                    }
                    newNodeList.add(map.get(given));
                }
                newNode.neighbors = newNodeList;
            }                  
        }

        return newHead;
        
    }
}
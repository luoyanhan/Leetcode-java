package Medium.NO133;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if (node==null){
            return node;
        }
        if (map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node neighbour:node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbour));
        }
        return newNode;
    }
}

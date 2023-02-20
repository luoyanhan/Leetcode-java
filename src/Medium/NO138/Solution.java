package Medium.NO138;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Node, Node> map = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        if (!map.containsKey(head)){
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}

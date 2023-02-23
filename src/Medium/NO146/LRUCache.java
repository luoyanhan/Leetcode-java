package Medium.NO146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node() {};
        Node(int k, int v){
            key = k;
            val = v;
        }
    }

    private Map<Integer, Node> records = new HashMap<Integer, Node>();
    int capacity;
    int length;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (records.containsKey(key)){
            Node node = records.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (!records.containsKey(key)) {
            if (length>=capacity) {
                removeNode(tail.pre);
            }
        }else {
            removeNode(records.get(key));
        }
        records.put(key, newNode);
        length++;
        newNode.pre = head;
        newNode.next = head.next;
        head.next = newNode;
        newNode.next.pre = newNode;
    }

    public void removeNode(Node node){
        Node next = node.next;
        next.pre = node.pre;
        node.pre.next = next;
        records.remove(node.key);
        length--;
    }
}

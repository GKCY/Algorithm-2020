package design;

import java.util.HashMap;

public class LRUCache {
    NodeList list;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new NodeList();
        this.capacity = capacity;
    }

    public int get(int key){
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToTail(node);
            return node.getValue();
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.setValue(value);
            list.moveToTail(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            list.add(node);
            if (list.size > capacity)
                map.remove(list.removeHead());
        }
    }
}

class NodeList{
    int size;
    Node head;
    Node tail;

    public NodeList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        size = 0;
    }

    public void  add(Node node) {
        Node pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
        size++;
    }

    public void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    public void moveToTail(Node node) {
        remove(node);
        add(node);
    }

    public int removeHead() {
        int key = head.next.getKey();
        remove(head.next);
        return key;
    }

    public int size() {
        return size;
    }
}

class Node {
    private int k;
    private int v;
    Node pre;
    Node next;
    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
    public int getValue() {
        return v;
    }
    public int getKey() {
        return k;
    }
    public void setValue(int value){
        this.v = value;
    }
}

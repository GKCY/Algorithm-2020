package base;

import java.util.*;

public class No133 {
    private class Node {
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

//    HashMap<Integer, Node> map = new HashMap<>();
//    HashSet<Integer> set = new HashSet<>();
//    public Node cloneGraph(Node node) {
//        if (node == null)
//            return null;
//        clone(node);
//        return map.get(node.val);
//    }
//
//    public void clone(Node node) {
//        Node copy;
//        if (map.containsKey(node.val))
//            copy = map.get(node.val);
//        else {
//            copy = new Node(node.val);
//            map.put(node.val, copy);
//        }
//        for (Node neighbor : node.neighbors) {
//            if (!map.containsKey(neighbor.val))
//                map.put(neighbor.val, new Node(neighbor.val));
//            copy.neighbors.add(map.get(neighbor.val));
//        }
//        set.add(node.val);
//        for (Node neighbor : node.neighbors) {
//            if (!set.contains(neighbor.val))
//                clone(neighbor);
//        }
//    }

    //dfs
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph1(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph1(neighbor));
        }
        return copy;
    }

    public Node cloneGraph2(Node node){
        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node copy = new Node(node.val);
        map.put(node, copy);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }
}

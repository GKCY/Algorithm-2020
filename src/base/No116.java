package base;

import java.util.LinkedList;
import java.util.Queue;

public class No116 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

//    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node cur = queue.poll();
//                if (i == size - 1)
//                    cur.next = null;
//                else
//                    cur.next = queue.peek();
//                if (cur.left != null)
//                    queue.offer(cur.left);
//                if (cur.right != null)
//                    queue.offer(cur.right);
//            }
//        }
//        return root;
//    }

    public Node connect(Node root) {
        if (root == null || root.left == null)
            return root;
        root.left.next = root.right;
        if (root.next == null)
            root.right.next = null;
        else
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect2(Node root) {
        if (root == null)
            return root;
        Node head = root;
        while (head.left != null) {
            Node first = head;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            head = first.left;
        }
        return root;
    }
}

package base;

public class No117 {
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

    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node first = findLeftChild(head);
            while (head != null) {
                if (head.left != null && head.right != null)
                    head.left.next = head.right;
                else if (head.left != null)
                    head.left.next = findLeftChild(head.next);
                if (head.right != null)
                    head.right.next = findLeftChild(head.next);
                head = head.next;
            }
            head = first;
        }
        return root;
    }

    public Node findLeftChild(Node head) {
        while (head != null) {
            if (head.left != null)
                return head.left;
            if (head.right != null)
                return head.right;
            head = head.next;
        }
        return null;
    }

    public Node connect2(Node root) {
        Node head = root;
        while (head != null) {
            Node pre = null;
            Node cur = head;
            Node nextHead = null;
            while (cur != null) {
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    if (pre == null)
                        nextHead = cur.left;
                     else
                        pre.next = cur.left;
                    pre = cur.right;
                } else if (cur.left != null) {
                    if (pre == null)
                        nextHead = cur.left;
                    else
                        pre.next = cur.left;
                    pre = cur.left;
                } else if (cur.right != null) {
                    if (pre == null)
                        nextHead = cur.right;
                    else
                        pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            head = nextHead;
        }
        return root;
    }
}

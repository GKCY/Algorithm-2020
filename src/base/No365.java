package base;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class No365 {
    private class Node {
        int dx;
        int dy;

        public Node(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dx, dy);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj instanceof Node) {
                Node o = (Node)obj;
                return o.dx == this.dx && o.dy == this.dy;
            }
            return false;
        }
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        if (x + y < z)
            return false;
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(0, 0);
        queue.offer(root);
        set.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.dx == z || node.dy == z || node.dx + node.dy == z)
                return true;

            Node tmp = new Node(x, node.dy);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }

            tmp = new Node(node.dx, y);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }

            tmp = new Node(0, node.dy);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }

            tmp = new Node(node.dx, 0);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }

            int a, b, sum = node.dx + node.dy;
            a = sum > y ? sum - y : 0;
            b = sum > y ? y : sum;
            tmp = new Node(a, b);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }

            a = sum > x ? x : sum;
            b = sum > x ? sum - x : 0;
            tmp = new Node(a, b);
            if (!set.contains(tmp)) {
                queue.offer(tmp);
                set.add(tmp);
            }
        }
        return false;
    }
}

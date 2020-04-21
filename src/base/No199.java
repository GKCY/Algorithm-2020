package base;

import DS.TreeNode;

import java.util.*;

public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                if (node.right != null)
                    deque.offerFirst(node.right);
                if (node.left != null)
                    deque.offerFirst(node.left);
                if (i == 0)
                    res.add(node.val);
            }
        }
        return res;
    }
}

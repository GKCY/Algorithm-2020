package base;

import DS.TreeNode;

import java.util.*;

public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null)
            deque.add(root);
        boolean right = true;
        while (!deque.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = deque.size();
            if (right) {
                while (size-- > 0) {
                    TreeNode node = deque.pollFirst();
                    temp.add(node.val);
                    if (node.left != null)
                        deque.offerLast(node.left);
                    if (node.right != null)
                        deque.offerLast(node.right);
                }
                right = false;
            } else if (!right) {
                while (size-- > 0) {
                    TreeNode node = deque.pollLast();
                    temp.add(node.val);
                    if (node.right != null)
                        deque.offerFirst(node.right);
                    if (node.left != null)
                        deque.offerFirst(node.left);
                }
                right = true;
            }
            res.add(temp);
        }
        return res;
    }
}

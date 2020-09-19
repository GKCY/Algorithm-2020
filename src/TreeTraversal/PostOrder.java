package TreeTraversal;

import DS.TreeNode;

import java.util.*;

public class PostOrder {

    public List<Integer> Traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || pre == cur.right) {
                stack.pop();
                res.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
                pre = null;
            }
        }
        return res;
    }
}

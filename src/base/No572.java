package base;

import DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //迭代解法
//        if (s == null)
//            return false;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(s);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (isEqual(node, t))
//                return true;
//            if (node.left != null)
//                queue.offer(node.left);
//            if (node.right != null)
//                queue.offer(node.right);
//        }
//        return false;
        if (s == null)
            return false;
        if (isEqual(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isEqual(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 ==null || n2 == null)
            return false;
        return n1.val == n2.val && isEqual(n1.left, n2.left)
                                && isEqual(n1.right, n2.right);
    }
}

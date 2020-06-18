package base;

import DS.TreeNode;

import java.util.Stack;

public class No285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode ptr = p.right;
            while (ptr.left != null)
                ptr = ptr.left;
            return ptr;
        } else if (p == root)
            return null;

        TreeNode pre = null;
        TreeNode ptr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || ptr != null) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            if (pre != null && pre == p)
                return ptr;
            pre = ptr;
            ptr = ptr.right;
        }
        return null;
    }
}

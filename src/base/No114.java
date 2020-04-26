package base;

import DS.TreeNode;

import java.util.Stack;

public class No114 {
    public void flatten(TreeNode root) {
        TreeNode dummy = null;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        else
            stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            pre = node;
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    public void flatten2(TreeNode root) {
        while (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null) {
                root.right = left;
                TreeNode ptr = left;
                while (ptr.right != null)
                    ptr = ptr.right;
                ptr.right = right;
            }
            root.left = null;
            root = root.right;
        }
    }

    TreeNode pre = null;
    public void flatten3(TreeNode root) {
        if (root == null)
            return;
        flatten3(root.right);
        flatten3(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

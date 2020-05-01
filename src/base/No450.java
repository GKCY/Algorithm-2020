package base;

import DS.TreeNode;

public class No450 {
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key == root.val) {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null) {
                int next = successor(root);
                root.val = next;
                root.right = deleteNode(root.right, next);
            } else {
                int pre = predecessor(root);
                root.val = pre;
                root.left = deleteNode(root.left, pre);
            }

        }
        return root;
    }
}

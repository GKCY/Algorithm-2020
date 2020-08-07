package base;

import DS.TreeNode;

public class No814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null)
            return root.val == 1 ? root : null;
        else
            return root;
    }
}

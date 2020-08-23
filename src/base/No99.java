package base;

import DS.TreeNode;

public class No99 {
    TreeNode pre = null;
    TreeNode node1 = null;
    TreeNode node2 = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (node1 != null && node2 != null) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre == null || pre.val < root.val)
            pre = root;
        else if (pre.val > root.val) {
            if (node1 == null) {
                node1 = pre;
                node2 = root;
            } else {
                node2 = root;
            }
        }
        inOrder(root.right);
    }
}

package competition;

import DS.TreeNode;

public class No5398 {
    int res = 0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return res;
    }

    public void goodNodes(TreeNode root, int max) {
        if (root == null)
            return;
        if (max <= root.val) {
            res++;
            max = root.val;
        }
        goodNodes(root.left, max);
        goodNodes(root.right, max);
    }
}

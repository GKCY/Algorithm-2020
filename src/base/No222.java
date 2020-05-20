package base;

import DS.TreeNode;


public class No222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight)
            return countNodes(root.right) + (1 << leftHeight);
        else
            return countNodes(root.left) + (1 << rightHeight);
    }

    public int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}

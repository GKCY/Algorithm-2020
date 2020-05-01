package base;

import DS.TreeNode;

public class No106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node = build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
        return node;
    }

    public TreeNode build(int[] postorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1)
            return null;
        int index = -1;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == postorder[e1]) {
                index = i;
                break;
            }
        }
        int left = index - s2;
        TreeNode node = new TreeNode(postorder[s1]);
        node.left = build(postorder, s1, s1 + left - 1, inorder, s2, index-1);
        node.right = build(postorder, s1 + left, e1 - 1, inorder, index+1, e2);
        return node;
    }
}

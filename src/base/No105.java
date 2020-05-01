package base;

import DS.TreeNode;

public class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return node;
    }

    public TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1)
            return null;
        int index = -1;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1])
                index = i;
                break;
        }
        int left = index - s2;
        int right = e2 - index;
        TreeNode node = new TreeNode(preorder[s1]);
        node.left = build(preorder, s1 + 1, s1 + left, inorder, s2, index-1);
        node.right = build(preorder, s1 + left + 1, e1, inorder, index+1, e2);
        return node;
    }
}

package TreeTraversal;

import DS.TreeNode;

public class Morris {
    // https://zhuanlan.zhihu.com/p/101321696

    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                } else {
                    mostRight.right = cur;
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                }
            } else {
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else if (mostRight.right == cur){
                    mostRight.right = null;
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                }
            } else {
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Morris morris = new Morris();
        morris.preOrder(root);
        morris.inOrder(root);
    }
}

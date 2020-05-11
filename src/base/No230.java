package base;

import DS.TreeNode;
import java.util.Stack;

public class No230 {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (++count == k)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}

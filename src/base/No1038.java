package base;

import DS.TreeNode;

import java.util.Stack;

public class No1038 {
    public TreeNode bstToGst(TreeNode root) {
        int value = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            value += node.val;
            node.val = value;
            cur = node.left;
        }
        return root;
    }
}

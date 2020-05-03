package design;

import DS.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode node = stack.pop();
        root = node.right;
        return node.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || root != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

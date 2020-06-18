package base;

import DS.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1028 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0;
        while (i < S.length()) {
            int depth = 0;
            while (S.charAt(i) == '-') {
                i++;
                depth++;
            }
            int num = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                num = num * 10 + S.charAt(i) - '0';
                i++;
            }
            TreeNode node = new TreeNode(num);
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }
            while (depth < stack.size())
                stack.pop();
            if (stack.peek().left == null)
                stack.peek().left = node;
            else
                stack.peek().right = node;
            stack.push(node);
        }
        return stack.pollFirst();
    }

    public static void main(String[] args) {
        new No1028().recoverFromPreorder("1-2--3--4-5--6--7");
    }
}

package base;

import DS.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Double> res = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            double num = queue.size();
            long sum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add((double)(sum / num));
        }
        return res;
    }
}

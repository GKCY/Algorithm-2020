package base;

import DS.TreeNode;

import java.util.HashMap;

public class No437 {

    private HashMap<Integer, Integer> map;
    private int res;
    private int sum;
    public int pathSum(TreeNode root, int sum) {
        map = new HashMap<>();
        map.put(0, 1);
        res = 0;
        this.sum = sum;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int curSum) {
        if (root == null)
            return;
        curSum += root.val;
        res += map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
}

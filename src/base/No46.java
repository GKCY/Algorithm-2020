package base;

import java.util.ArrayList;
import java.util.List;

public class No46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        trackback(res, path, visited, nums);
        return res;
    }

    public void trackback(List<List<Integer>> res,
                          ArrayList<Integer> path,
                          int[] visited,
                          int[] nums) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                path.add(nums[i]);
                trackback(res, path, visited, nums);
                visited[i] = 0;
                path.remove(path.size()-1);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int start){
        for (int i = start ; i < candidates.length; i++) {
            int candidate = candidates[i];
            temp.add(candidate);
            int distance = target - candidate;
            if (distance == 0){
                res.add(new ArrayList<>(temp));
            } else if (distance > 0) {
                dfs(candidates, target, i);
            } else if (distance < 0) {
                temp.remove(temp.size()-1);
                break;
            }
            temp.remove(temp.size()-1);
        }
    }
}

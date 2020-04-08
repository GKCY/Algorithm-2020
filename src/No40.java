import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(candidates, target, 0, track, res);
        return res;
    }

    public void backtrack(int[] candidates,
                          int target,
                          int start,
                          ArrayList<Integer> track,
                          List<List<Integer>> res){
        if (target == 0)
            res.add(new ArrayList<>(track));
        for (int i = start; i < candidates.length; i++){
            int candidate = candidates[i];
            if (target - candidate < 0)
                break;
            if (i > start && candidates[i] == candidates[i-1])
                continue;
            track.add(candidate);
            backtrack(candidates, target-candidate, i+1, track, res);
            track.remove(track.size()-1);
        }
    }
}

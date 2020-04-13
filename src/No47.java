import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                    continue;
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(nums);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        No47 t = new No47();
        System.out.println(t.permuteUnique(new int[]{1,1,3,3}));
    }
}

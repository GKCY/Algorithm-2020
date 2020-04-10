import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            findK(nums, i, res);
        }
        return res;
    }

    public void findK(int[] nums, int k, List<List<Integer>> res) {
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, k, 0, res, temp);
    }

    public void backtrack(int[] nums, int k, int start,
                          List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            backtrack(nums, k, i+1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}

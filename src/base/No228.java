package base;

import java.util.ArrayList;
import java.util.List;

public class No228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        int start = 0, end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[end] == 1) {
                end = i;
            } else {
                print(res, start, end, nums);
                start = end = i;
            }
        }
        print(res, start, end, nums);
        return res;
    }

    public void print(List<String> res, int start, int end, int[] nums) {
        if (start == end)
            res.add(String.valueOf(nums[start]));
        else
            res.add(String.valueOf(nums[start] + "->" + nums[end]));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new No228().summaryRanges(nums));
    }
}

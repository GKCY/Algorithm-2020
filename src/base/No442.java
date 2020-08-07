package base;

import java.util.ArrayList;
import java.util.List;

public class No442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                res.add(num);
            }
            nums[num-1] = -nums[num-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new No442().findDuplicates(nums));
    }
}

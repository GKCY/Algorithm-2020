package base;

import java.util.HashSet;

public class No128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : set) {
            if (set.contains(num - 1))
                continue;
            int len = 1;
            int cur = num;
            while (set.contains(cur + 1)) {
                len++;
                cur++;
            }
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new No128().longestConsecutive(nums));
    }
}

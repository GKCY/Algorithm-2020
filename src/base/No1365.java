package base;

import java.util.Arrays;

public class No1365 {
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = i;
        }
        Arrays.sort(tmp, (a, b) -> nums[a] - nums[b]);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            while (idx > 0 && nums[tmp[idx]] == nums[tmp[idx-1]]) {
                idx--;
            }
            res[tmp[i]] = idx;
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] frequency = new int[101];
        for (int num: nums)
            frequency[num]++;
        for (int i = 1; i < 101; i++)
            frequency[i] += frequency[i-1];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res[i] = frequency[nums[i] - 1];
        }
        return res;
    }
}

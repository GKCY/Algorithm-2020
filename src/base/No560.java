package base;

import java.util.HashMap;

public class No560 {

    public int subarraySum1(int[] nums, int k) {
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == k)
                res++;
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k)
                    res++;
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

package base;

import java.util.HashMap;

public class No1248 {
    public int numberOfSubarrays1(int[] nums, int k) {
        int res = 0;
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            if (nums[i] % 2 == 1) {
                dp[i][i] = 1;
            }
            if (dp[i][i] == k)
                res++;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j + i >= size)
                    break;
                if (nums[j+i] % 2 == 1)
                    dp[j][j+i] = dp[j][j+i-1] + 1;
                else
                    dp[j][j+i] = dp[j][j+i-1];
                if (dp[j][j+i] == k)
                    res++;
            }
        }
        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int res = 0;
        int size = nums.length;
        boolean[] visited = new boolean[size];
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            for (int step = 0; step < size; step++) {
                if (i + step >= size || visited[i])
                    break;
                if (nums[i+step] % 2 == 1)
                    dp[i] += 1;
                if (dp[i] == k)
                    res++;
                if (dp[i] > k)
                    visited[i] = true;
            }
        }
        return res;
    }

    public int numberOfSubarrays3(int[] nums, int k) {
        int[] stats = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                count++;
            stats[i] = count;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int amount : stats) {
            if (map.containsKey(amount-k))
                res += map.get(amount-k);
            if (!map.containsKey(amount))
                map.put(amount, 0);
            map.put(amount, map.get(amount)+1);
        }
        return res;
    }

    // 前缀数组法
    public int numberOfSubarrays4(int[] nums, int k) {
        int[] statics = new int[nums.length+1];
        statics[0] = 1;
        int res = 0, count = 0;
        for (int num: nums) {
            count += num & 1;
            statics[count]++;
            if (count >= k)
                res += statics[count-k];
        }
        return res;
    }

    //滑动窗口法
    public int numberOfSubarrays5(int[] nums, int k) {
        int left = 0, right = 0, count = 0, res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1)
                count++;
            if (count == k) {
                int temp = right;
                while (temp < nums.length && (nums[temp] & 1) == 0)
                    temp++;
                int rightCount = temp - right;
                int leftCount = 0;
                while ((nums[left] & 1) == 0) {
                    leftCount++;
                    left++;
                }

                res += (leftCount + 1) * (rightCount + 1);
                left++;
                count--;
            }

        }
        return res;
    }
}

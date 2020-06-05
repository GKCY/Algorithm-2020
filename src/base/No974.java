package base;

import java.util.HashMap;

public class No974 {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0, res = 0;
        for (int num : A) {
            sum += num;
            int n = ((sum % K) + K) % K;
            int cnt = prefixSum.getOrDefault(n, 0);
            res += cnt;
            prefixSum.put(n, cnt+1);
        }
        return res;
    }
}

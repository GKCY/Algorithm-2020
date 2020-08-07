package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        ArrayList<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int num : list) {
                pairs.add(new int[]{i, num});
            }
        }
        pairs.sort((a, b) -> (a[1] - b[1]));
        int[] map = new int[nums.size()];
        int count = 0;
        int[] res = {pairs.get(0)[1], pairs.get(pairs.size()-1)[1]};

        int l = 0, r = 0;
        while (r < pairs.size()) {
            if (map[pairs.get(r++)[0]]++ == 0)
                count++;
            while (count == nums.size()) {
                int left = pairs.get(l)[1];
                int right = pairs.get(r-1)[1];
                if (right - left < res[1] - res[0] ||
                        (right - left == res[1] - res[0] && left < res[0])) {
                    res[0] = left;
                    res[1] = right;
                }
                if (--map[pairs.get(l++)[0]] == 0)
                    count--;
            }
        }
        return res;
    }
}

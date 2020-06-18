package base;

import java.util.Arrays;
import java.util.Comparator;

public class No1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });
        int res = intervals.length;
        int maxRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (maxRight >= intervals[i][1])
                res--;
            else
                maxRight = intervals[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,4},{3,6},{2,8}};
        System.out.println(new No1288().removeCoveredIntervals(nums));
    }
}

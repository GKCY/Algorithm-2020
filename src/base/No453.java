package base;

import java.util.Arrays;

public class No453 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int end = points[0][1];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0])
                count++;
            else
                end = points[i][1];
        }
        return points.length - count;
    }
}

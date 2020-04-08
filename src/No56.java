import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class No56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][];
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.isEmpty())
                res.add(new int[]{left, right});
            else {
                if (res.getLast()[1] >= left)
                    res.getLast()[1] = Integer.max(res.getLast()[1], right);
                else
                    res.add(new int[]{left, right});
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}

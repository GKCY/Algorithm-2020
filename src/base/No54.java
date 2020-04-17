package base;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        int count = m * n;
        int left = 0, right = n - 1, top = 0, down = m - 1;
        while (true) {
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            if (++top > down) break;
            for (int i = top; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int j = right; j >= left; j--) res.add(matrix[down][j]);
            if (--down < top) break;
            for (int i = down; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}

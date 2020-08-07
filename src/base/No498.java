package base;

import tool.Utils;

public class No498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;

        int[] res = new int[m*n];
        boolean up = true;
        int idx = 0, dx = -1, dy = 1;
        for (int i = 1; i <= m + n - 1; i++) {
            int[] point = cal(i, up, m, n);
            while (point[0] >= 0 && point[0] < m
                    && point[1] >= 0 && point[1] < n) {
                res[idx++] = matrix[point[0]][point[1]];
                point[0] += dx;
                point[1] += dy;
            }
            up = !up;
            dx = -dx;
            dy = -dy;
        }
        return res;
    }

    public int[] cal(int i, boolean up, int m, int n) {
        if (up) {
            if (i <= m) {
                return new int[]{i-1, 0};
            } else
                return new int[]{m-1, i-m};
        } else {
            if (i <= n) {
                return new int[]{0, i-1};
            } else
                return new int[]{i-n,n-1};
        }
    }

    public static void main(String[] args) {
        No498 t = new No498();
//        int[] nums = t.cal(5, true, 3, 3);
//        Utils.printArrays(nums);
        Utils.printArrays(t.cal(2, false, 2, 1));
    }
}

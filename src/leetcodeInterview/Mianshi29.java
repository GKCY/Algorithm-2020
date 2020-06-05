package leetcodeInterview;

public class Mianshi29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        int count = 0;
        int[] res = new int[m * n];
        int left = 0, right = n - 1, top = 0, down = m - 1;
        while (true) {
            for (int j = left; j <= right; j++) res[count++] = matrix[top][j];
            if (++top > down) break;
            for (int i = top; i <= down; i++) res[count++] = matrix[i][right];
            if (--right < left) break;
            for (int j = right; j >= left; j--) res[count++] = matrix[down][j];
            if (--down < top) break;
            for (int i = down; i >= top; i--) res[count++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}

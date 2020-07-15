package base;

public class No378 {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length-1][matrix[0].length-1];
        while (l < r) {
            int mid = (l + r) / 2;
            boolean greater = midGreaterThanK(matrix, mid, k);
            if (greater)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private boolean midGreaterThanK(int[][] matrix, int mid, int K) {
        int i = matrix.length - 1;
        int n = matrix[0].length;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                j++;
            } else {
                count += j;
                i--;
            }
        }
        if (i >= 0)
            count += (i + 1) * n;
        return count >= K;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {1, 13, 13},
                {12, 15, 16}
        };
        System.out.println(new No378().kthSmallest(matrix, 4));
    }
}

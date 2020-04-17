package base;

public class No73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        boolean isRow0 = false;
        boolean isCol0 = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    if (i == 0)
                        isRow0 = true;
                    if (j == 0)
                        isCol0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (isRow0)
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }

        if (isCol0)
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }

    }
}

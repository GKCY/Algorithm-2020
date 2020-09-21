package competition;

import tool.Utils;

public class No5521 {
    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][] min = new long[row][col];
        long[][] max = new long[row][col];

        min[0][0] = grid[0][0];
        max[0][0] = grid[0][0];

        for (int j = 1; j < col; j++) {
            min[0][j] = min[0][j-1] * grid[0][j];
            max[0][j] = max[0][j-1] * grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            min[i][0] = min[i-1][0] * grid[i][0];
            max[i][0] = max[i-1][0] * grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] >= 0) {
                    max[i][j] = Math.max(max[i-1][j], max[i][j-1]) * grid[i][j];
                    min[i][j] = Math.min(min[i-1][j], min[i][j-1]) * grid[i][j];
                } else {
                    min[i][j] = Math.max(max[i-1][j], max[i][j-1]) * grid[i][j];
                    max[i][j] = Math.min(min[i-1][j], min[i][j-1]) * grid[i][j];
                }
            }
        }

//        Utils.printMatrix(max);
//        System.out.println("---------------------------------");
//        Utils.printMatrix(min);

        return max[row-1][col-1] >= 0 ? (int) ((max[row - 1][col - 1]) % 1000000007) : -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,-1,2,1,-1,0,0,4,3,2,0,-2,-2},{-2,3,3,-1,-1,0,0,-2,4,-3,3,0,0},{-4,-1,-1,-2,2,-1,-2,-2,0,3,-1,-4,1},{-3,4,-3,0,-3,1,-3,1,4,4,-4,-4,-2},{3,-3,1,0,-1,-4,-4,-4,3,2,2,3,3},{2,-1,-1,-4,-3,-3,4,2,3,4,4,-4,0},{4,-1,2,-3,-1,-1,-3,-4,4,4,4,-3,-1},{-3,-4,4,-2,-1,2,3,-1,2,3,4,4,-4},{-3,-1,-2,1,1,-1,-3,-4,-3,1,-3,3,-4},{2,4,4,4,-3,-3,1,-1,3,4,-1,1,4},{2,-2,0,4,-1,0,-2,4,-4,0,0,2,-3},{1,1,-3,0,-4,-4,-4,-4,0,-1,-4,-1,0},{3,-1,-3,-3,-3,-2,-1,4,-1,-2,4,2,3}};
        System.out.println(new No5521().maxProductPath(matrix));
    }
}

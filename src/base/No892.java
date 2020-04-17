package base;

public class No892 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                if (height > 0)
                    res += 2;
                res += 4 * height;
                if (i-1 >= 0)
                    res -= Integer.min(height, grid[i-1][j]);
                if (i+1 < n)
                    res -= Integer.min(height, grid[i+1][j]);
                if (j-1 >= 0)
                    res -= Integer.min(height, grid[i][j-1]);
                if (j+1 < n)
                    res -= Integer.min(height, grid[i][j+1]);
            }
        }
        return res;
    }
}

package base;

public class No695 {
    int m, n;
    boolean[][] visited;
    int maxArea = 0;
    int sum;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    sum = 0;
                    dfs(grid, i, j);
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        sum++;
        visited[i][j] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (valid(x, y) && !visited[x][y] && grid[x][y] == 1)
                dfs(grid, x, y);
        }
    }

    public boolean valid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

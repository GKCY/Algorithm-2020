package base;

public class No200 {
    boolean[][] visited;
    int res = 0;
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j] ) {
                    res++;
                    visited[i][j] = true;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n
                    && grid[x][y] == '1' && !visited[x][y]) {
                visited[x][y] = true;
                dfs(x, y, grid);
            }
        }
    }

    public static void main(String[] args) {
    }
}

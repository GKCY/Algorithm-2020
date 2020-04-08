import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No1162 {
    private static final int INF = 1000;
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : INF;
                if (i-1 >= 0) dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j]);
                if (j-1 >= 0) dp[i][j] = Math.min(dp[i][j-1]+1, dp[i][j]);
            }
        }

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                if (j+1 < n) dp[i][j] = Math.min(dp[i][j+1]+1, dp[i][j]);
                if (i+1 < n) dp[i][j] = Math.min(dp[i+1][j]+1, dp[i][j]);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dp[i][j] > res)
                    res = dp[i][j];
            }
        }
        return (res == INF || res == Integer.MIN_VALUE) ? -1 : res;
    }

    class point {
        int x;
        int y;
        int step;

        public point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public int maxDistance2(int[][] grid) {
        int n = grid.length;
        int res = -1;
        Queue<point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n)
                    continue;
                if (!visited[x][y]) {
                    queue.add(new point(x, y, p.step+1));
                    visited[x][y] = true;
                    res = Math.max(res, p.step+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No1162 t = new No1162();
        int[][] m = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        System.out.println(t.maxDistance(m));
    }
}

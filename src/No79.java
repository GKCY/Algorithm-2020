public class No79 {
    char[] w;
    char[][] b;
    int m;
    int n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        w = word.toCharArray();
        b = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                if (search(i, j, 0))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }
    public boolean search(int i, int j, int index) {
        if (b[i][j] == w[index]) {
            if (index == w.length-1)
                return true;
            else {
                int[] dx = {0, 0, 1, -1};
                int[] dy = {1, -1, 0, 0};
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        if (search(x, y, index+1))
                            return true;
                        visited[x][y] = false;
                    }
                }
                return false;
            }

        } else {
            return false;
        }

    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Mianshi13 {

    private class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        if (calCoordinate(0, 0) <= k) {
            visited[0][0] = true;
            queue.offer(new Coordinate(0,0));
            res++;
        }
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        while (!queue.isEmpty()) {
            Coordinate p = queue.peek();
            queue.poll();
            for (int i = 0; i < 2; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n &&
                        !visited[x][y] && calCoordinate(x, y) <= k) {
                    visited[x][y] = true;
                    queue.offer(new Coordinate(x, y));
                    res++;
                }
            }
        }
        return res;
    }

    public int calCoordinate(int x, int y) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        while (y != 0) {
            res += y % 10;
            y /= 10;
        }
        return res;
    }

    //    public int calSum(int y) {
//        int res = 0;
//        while (y != 0) {
//            res += y % 10;
//            y /= 10;
//        }
//        return res;
//    }
//
//    public int calCoordinate(int x, int y) {
//        return calSum(x) + calSum(y);
//    }
}

package base;

import java.util.LinkedList;
import java.util.Queue;

public class No733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1,-1, 0, 0};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
                    queue.offer(new int[]{x, y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }
}

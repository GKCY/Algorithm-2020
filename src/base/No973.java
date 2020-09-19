package base;

import java.util.PriorityQueue;

public class No973 {

	class Point {
		int x;
		int y;
		int dist;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.dist = x * x + y * y;
		}
	}

	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<Point> priorityQueue = new PriorityQueue<>((a, b)->(a.dist - b.dist));
		for (int[] point : points) {
			priorityQueue.offer(new Point(point[0], point[1]));
		}
		int[][] res = new int[K][2];
		for (int i = 0; i < K; i++) {
			Point point = priorityQueue.poll();
			res[i][0] = point.x;
			res[i][1] = point.y;
		}
		return res;
		
    }
}
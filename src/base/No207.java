package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No207 {
    //拓扑排序法
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] pair: prerequisites) {
            indegrees[pair[0]]++;
            adjacency.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            numCourses--;
            int from = queue.poll();
            for (int to: adjacency.get(from)) {
                if (--indegrees[to] == 0)
                    queue.add(to);
            }
        }
        return numCourses == 0;

    }
}

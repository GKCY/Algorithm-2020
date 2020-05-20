package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            table.add(new ArrayList());
        }
        int[] in = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;

        for (int[] prerequisite : prerequisites) {
            table.get(prerequisite[1]).add(prerequisite[0]);
            in[prerequisite[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index] = course;
            index++;
            for (int nextCourse : table.get(course)) {
                if (--in[nextCourse] == 0)
                    queue.add(nextCourse);
            }
        }

        if (index != numCourses)
            return new int[0];

        return res;
    }
}

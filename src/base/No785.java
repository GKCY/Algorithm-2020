package base;

import java.util.LinkedList;
import java.util.Queue;

public class No785 {
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0)
            return true;
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int point = queue.poll();
                    int curColor = color[point];
                    int nextColor = curColor == 1 ? 2 : 1;
                    for(int neighbor: graph[point]) {
                        if (color[neighbor] == curColor)
                            return false;
                        else if (color[neighbor] == nextColor)
                            continue;
                        else if (color[neighbor] == 0){
                            color[neighbor] = nextColor;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{}};
        System.out.println(new No785().isBipartite(graph));
    }
}

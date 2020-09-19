package base;

import java.util.List;

public class No841 {
    boolean[] visited;
    int count;
    List<List<Integer>> rooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        count = rooms.size();
        visited = new boolean[rooms.size()];
        visited[0] = true;
        count--;
        dfs(0);
        return count == 0;
    }

    private void dfs(int id) {
        for (int next : rooms.get(id)) {
            if (!visited[next]) {
                visited[next] = true;
                count--;
                dfs(next);
            }
        }
    }
}

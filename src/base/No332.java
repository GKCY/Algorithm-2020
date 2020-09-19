package base;

import java.util.*;

public class No332 {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> stack = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            String src = pair.get(0), dst = pair.get(1);
            if (!map.containsKey(src))
                map.put(src, new PriorityQueue<>());
            map.get(src).add(dst);
        }
        dfs("JFK");
        Collections.reverse(stack);
        return stack;
    }

    public void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String next = map.get(cur).poll();
            dfs(next);
        }
        stack.addLast(cur);
    }
}

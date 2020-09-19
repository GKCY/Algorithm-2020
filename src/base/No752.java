package base;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class No752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for (String deadend : deadends)
            dead.add(deadend);
        visited.add("0000");

        if (!dead.contains("0000"))
            queue.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) { ;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(target))
                    return depth;
                for (int j = 0; j < 4; j++) {
                    String next;
                    char ch = str.charAt(j);
                    ch = ch == '0' ? '9' : (char) (ch - 1);
                    next = str.substring(0, j) + String.valueOf(ch) + str.substring(j+1, 4);
                    if (!visited.contains(next) && !dead.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    ch = str.charAt(j);
                    ch = ch == '9' ? '0' : (char) (ch + 1);
                    next = str.substring(0, j) + String.valueOf(ch) + str.substring(j+1, 4);
                    if (!visited.contains(next) && !dead.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] dead = {"8888"};
        String target = "0009";
        System.out.println(new No752().openLock(dead, target));
    }
}

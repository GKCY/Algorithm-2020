package base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        int step = 1;
        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && canReplace(beginWord, wordList.get(i))) {
                queue.offer(wordList.get(i));
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord))
                    return step;
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && canReplace(str, wordList.get(j))){
                        queue.offer(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;
    }

    public boolean canReplace(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }
}

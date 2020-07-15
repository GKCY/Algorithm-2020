package leetcodeInterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mianshi17dot13 {
    public int respace1(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j <= i; j++) {
                if (set.contains(sentence.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[n];
    }

    private class trie {
        boolean word;
        trie[] alphabet;

        public trie() {
            this.word = false;
            alphabet = new trie[26];
        }

        public boolean exist(char c) {
            return alphabet[c-'a'] != null;
        }

        public trie get(char c) {
            return alphabet[c-'a'];
        }

        public void create(char c){
            alphabet[c-'a'] = new trie();
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public boolean isWord() {
            return word;
        }

        public void insert(String str) {

        }
    }

    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        trie root = new trie();

        for (String str : dictionary) {
            trie ptr = root;
            for (int i = str.length()-1; i >= 0; i--) {
                char c = str.charAt(i);
                if (!ptr.exist(c))
                    ptr.create(c);
                ptr = ptr.get(c);
            }
            ptr.setWord(true);
        }

        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i-1] + 1;
            trie cur = root;
            for (int idx = i-1; idx >= 0; idx--) {
                char c = sentence.charAt(idx);
                if (cur.exist(c))
                    cur = cur.get(c);
                else
                    break;
                if (cur.isWord())
                    dp[i] = Math.min(dp[i], dp[idx]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String[] str = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(new Mianshi17dot13().respace(str, sentence));
    }
}

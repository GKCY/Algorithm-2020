package base;

import java.util.HashMap;

public class No820 {
    public int minimumLengthEncoding(String[] words) {
        HashMap<trieTree, Integer> nodes = new HashMap<>();
        trieTree root = new trieTree();
        for (int i = 0; i < words.length; i++) {
            trieTree cur = root;
            String word = words[i];
            for (int j = word.length()-1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int res = 0;
        for (trieTree node :
                nodes.keySet()) {
            if (node.count == 0) {
                res += words[nodes.get(node)].length() + 1;
            }
        }
        return res;
    }

    class trieTree {
        int count;
        trieTree[] alphabet;

        public trieTree() {
            count = 0;
            alphabet = new trieTree[26];
        }

        public trieTree get(char ch) {
            int index = ch - 'a';
            if (alphabet[index] == null) {
                alphabet[index] = new trieTree();
                count++;
            }
            return alphabet[index];
        }
    }
}

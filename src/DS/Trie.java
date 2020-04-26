package DS;

// No208 实现Trie树
public class Trie {
    private class TrieNode {
        boolean isWord;
        int count;
        TrieNode[] alphabet;
        public TrieNode() {
            alphabet = new TrieNode[26];
            isWord = false;
            count = 0;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            cur.count++;
            int index = ch - 'a';
            if (cur.alphabet[index] == null)
                cur.alphabet[index] = new TrieNode();
            cur = cur.alphabet[index];
        }
        cur.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.alphabet[index] == null)
                return false;
            cur = cur.alphabet[index];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.alphabet[index] == null)
                return false;
            cur = cur.alphabet[index];
        }
        return cur.isWord || cur.count > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
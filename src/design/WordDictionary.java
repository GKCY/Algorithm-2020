package design;

public class WordDictionary {
    Trie root;

    private class Trie {
        int count = 0;
        boolean word = false;
        Trie[] dict = new Trie[26];
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.dict[ch - 'a'] == null)
                temp.dict[ch - 'a'] = new Trie();
            temp.count++;
            temp = temp.dict[ch - 'a'];
        }
        temp.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Trie root) {
        char ch = word.charAt(0);
        if (word.length() == 1) {
            if (ch == '.') {
                boolean flag = false;
                for (Trie node : root.dict) {
                    if (node != null)
                        flag = flag || node.word;
                }
                return flag;
            } else {
                if (root.dict[ch - 'a'] == null)
                    return false;
                return root.dict[ch - 'a'].word;
            }
        }

        String sub = word.substring(1, word.length());
        if (ch == '.') {
            if (root.count == 0)
                return false;
            else {
                boolean flag = false;
                for (Trie node : root.dict) {
                    if (node != null)
                        flag = flag || search(sub, node);
                }
                return flag;
            }
        } else {
            if (root.dict[ch - 'a'] == null)
                return false;
            else {
                return search(sub, root.dict[ch - 'a']);
            }
        }

    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

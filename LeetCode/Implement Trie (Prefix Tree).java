/**
 * 考察对数据结构 Trie 的理解和实现
 */

class TrieNode {

    private TrieNode[] children;

    private String item;

    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        item = "";
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = node.getChildren()[word.charAt(i) - 'a'];
            if (child == null) {
                child = new TrieNode();
                node.getChildren()[word.charAt(i) - 'a'] = child;
            }
            node = child;
        }
        node.setItem(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = node.getChildren()[word.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }
            node = child;
        }
        if (node.getItem().equals(word)) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = node.getChildren()[prefix.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }
            node = child;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
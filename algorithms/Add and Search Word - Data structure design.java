class Node {
    Node[] children = new Node[26];
    String word = "";
}

public class WordDictionary {

    private Node root = new Node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new Node();
            }
            p = p.children[index];
        }
        p.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int begin, Node p) {
        if (p == null) {
            return false;
        }
        if (begin == word.length() && p.word.length() == word.length() &&
                (word.charAt(begin - 1) == '.' || word.charAt(begin - 1) == p.word.charAt(begin - 1))) {
            return true;
        } else if (begin == word.length()) {
            return false;
        }
        if (word.charAt(begin) == '.') {
            for (int i = 0; i < 26; i++) {
                if (dfs(word, begin + 1, p.children[i])) {
                    return true;
                }
            }
        } else {
            int index = word.charAt(begin) - 'a';
            return dfs(word, begin + 1, p.children[index]);
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
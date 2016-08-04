/**
 * 这里 bfs 比 dfs 合适
 */
class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        wordDict.add(endWord);
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            char[] arr = word.toCharArray();
            if (word.equals(endWord)) {
                return top.numSteps;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if (wordDict.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}


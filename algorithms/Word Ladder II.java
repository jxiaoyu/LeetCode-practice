/**
 * 在 Word Ladder 的基础上改一下：
 * 1. WordNode 引入 pre 记录上个节点
 * 2. 不是向 queue 里每 add 一个元素就把它从 set 里移除掉，而是等本层都 add 完毕再一起 remove 
 */
class WordNode {
    String word;
    int numSteps;
    WordNode pre;

    public WordNode(String word, int numSteps, WordNode pre) {
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        int minSteps = 0, preSteps = 0;

        wordList.add(endWord);
        HashSet<String> visited = new HashSet<String>();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1, null));

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            char[] arr = word.toCharArray();
            if (word.equals(endWord)) {
                if (minSteps == 0) {
                    minSteps = top.numSteps;
                }
                if (top.numSteps == minSteps) {
                    List<String> list = new ArrayList<String>();
                    list.add(top.word);
                    while (top.pre != null) {
                        list.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(list);
                }
                continue;
            }

            if (top.numSteps > preSteps) {
                wordList.removeAll(visited);
            }
            preSteps = top.numSteps;

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if (wordList.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return result;
    }
}

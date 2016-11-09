public class Solution {
    public String originalDigits(String s) {
        String[] wordSeq = {"zero", "wto", "ufor", "xsi", "geiht", "one", "htree", "five", "seven", "inne"};
        int[] wordIndex = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        Node[] nodes = new Node[10];
        for (int i = 0; i < 10; i ++) {
            nodes[i] = new Node(wordSeq[i], wordIndex[i]);
        }
        
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (Node node : nodes) {
            String word = node.word;
            int wordNum = counts[word.charAt(0) - 'a'];
            if (wordNum > 0) {
                node.num = wordNum;
                for (int i = 0; i < word.length(); i++) {
                    counts[word.charAt(i) - 'a'] -= wordNum;
                }
            }
        }
        
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.index - b.index;
            }
        });
        
        String result = "";
        for (Node node : nodes) {
            for (int i = 0; i < node.num; i++) {
                result += node.index;
            }
        }
        return result;
    }
}

class Node {
    String word;
    int index, num;
    
    public Node(String word, int index) {
        this.word = word;
        this.index = index;
    }
}
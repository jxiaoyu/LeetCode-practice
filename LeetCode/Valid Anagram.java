/**
 * 这题不复杂，但还是有几点值得总结
 * 1. 
 * 我首先想到的思路是把 String 转换成字符数组，然后排序，比较。
 * 而看到别人的思路是用两个长度为 26 的数组分别来统计两个字符串中各个字母的数量，数组相等则为异构。这比我的思路节省内存
 * 
 * 2.
 * 这让我联想到了 Trie 这种数据结构，用 26 叉树来存储所有单词的组合，节省空间
 * 所以当基本元素落在一个小范围的时候，从基本元素出发，会比较合理
 * 
 * 3.
 * 题目的 follow up 问如果这两个字符串的字符不只是字母而是 unicode 怎么办？可以用一个 HashMap 来统计，
 * 一个向 map 里加，另一个减，最后 map 为空，则相等
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
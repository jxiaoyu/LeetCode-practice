/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NestedInteger());
                continue;
            }
            if (c == ',') {
                continue;
            }
            if (c == ']') {
                NestedInteger temp = stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().add(temp);
                } else {
                    stack.push(temp);
                }
                continue;
            }
            int j = i;
            while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
                j++;
            }
            if (j > i) {
                int num = Integer.parseInt(s.substring(i, j));
                if (!stack.isEmpty()) {
                    NestedInteger ni = new NestedInteger(num);
                    stack.peek().add(ni);
                } else {
                    NestedInteger ni = new NestedInteger(num);
                    stack.push(ni);
                }
                i = j - 1;
            }
        }
        return stack.peek();
    }
}
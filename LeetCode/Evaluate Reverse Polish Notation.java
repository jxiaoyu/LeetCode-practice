/**
 * 知道用栈就没什么难度了
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        
        for (String str : tokens) {
            if (str.equals("+")) {
                int val = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(Integer.toString(val));
                
            } else if (str.equals("-")) {
                int r = Integer.parseInt(stack.pop()), l = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(l - r));
                
            } else if (str.equals("*")) {
                int val = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(Integer.toString(val));
                
            } else if (str.equals("/")) {
                int r = Integer.parseInt(stack.pop()), l = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(l / r));
                
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
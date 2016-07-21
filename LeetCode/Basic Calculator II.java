/**
 * 用到栈，前面是加减号当前数就入栈，前面是乘除号就 pop 与当前数运算再入栈
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        s = s + '+';
        char op = '+';
        int num = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(' ')) {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                switch (op) {
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                }
                op = c;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
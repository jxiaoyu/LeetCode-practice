/**
 * 实现思路是用一个变量来标识现在的状态
 * 但是有很多重复代码
 */
class MyQueue {
    
    private Stack<Integer> stack = new Stack<>();
    
    private boolean in = true;
    
    // Push element x to the back of queue.
    public void push(int x) {
        if (!in) {
            Stack<Integer> newStack = new Stack<>();
            while (!stack.empty()) {
                newStack.push(stack.pop());
            }
            stack = newStack;
            in = !in;
        }
        stack.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (in) {
            Stack<Integer> newStack = new Stack<>();
            while (!stack.empty()) {
                newStack.push(stack.pop());
            }
            stack = newStack;
            in = !in;
        }
        stack.pop();
        
    }

    // Get the front element.
    public int peek() {
        if (in) {
            Stack<Integer> newStack = new Stack<>();
            while (!stack.empty()) {
                newStack.push(stack.pop());
            }
            stack = newStack;
            in = !in;
        }
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}
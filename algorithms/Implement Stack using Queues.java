/**
 * 和 Implement Queue using Stacks 是对称的
 */
class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> tmp = new LinkedList<>();
        while (!queue.isEmpty()) {
            tmp.add(queue.remove());
        }
        queue.add(x);
        
        while (!tmp.isEmpty()) {
            queue.add(tmp.remove());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.element();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
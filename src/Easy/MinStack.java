package Easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(!stack.empty()) stack.pop();
        if(!minStack.empty()) minStack.pop();
    }

    public int top() {
        return getTop(stack);
    }

    public int getMin() {
        return getTop(minStack);
    }

    public int getTop(Stack<Integer> stack) {
        if(stack.empty()) {
            return 0;
        }
        return stack.peek();
    }
}

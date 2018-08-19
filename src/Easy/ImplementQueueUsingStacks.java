package Easy;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Example:

 MyQueue queue = new MyQueue();

 queue.push(1);
 queue.push(2);
 queue.peek();  // returns 1
 queue.pop();   // returns 1
 queue.empty(); // returns false
 Notes:

 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

public class ImplementQueueUsingStacks {
    class MyQueue {

        public Stack<Integer> stack1 = new Stack<>();
        public Stack<Integer> stack2 = new Stack<>();
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(stack1.isEmpty()) stack1.push(x);
            else if(stack2.isEmpty()) stack2.push(x);
            else {
                while(!stack2.isEmpty())
                    stack1.push(stack2.pop());
                stack2.push(x);
                while(stack1.size() > 1)
                    stack2.push(stack1.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int result = stack1.pop();
            if(!stack2.isEmpty()) stack1.push(stack2.pop());
            return result;
        }

        /** Get the front element. */
        public int peek() {
            return stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    public void testMyQueue() {
        //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(11);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

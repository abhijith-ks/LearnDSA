package io.abhijith.challenges.amazon;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        if(!minStack.isEmpty()) {
            if(minStack.peek() < x) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public void findSolution() {
        push(5);
        push(7);
        push(2);
        push(3);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
    }

}

package com.wxweven.algorithm.array;

import java.util.Stack;

/**
 * @author wxweven
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    private void push(int num) {
        stack.push(num);
        if (minStack.isEmpty() || num < minStack.peek()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
    }

    private int pop() {
        if (!stack.isEmpty()) {
            minStack.pop();
            return stack.pop();
        } else {
            return -1;
        }
    }

    private int min() {
        return minStack.peek();
    }
}
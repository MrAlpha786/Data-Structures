package com.mralpha786.datastructures;

public class Stack {
    private final int[] stack;
    private int count = 0;

    public Stack() { // Default Constructor;
        this.stack = new int[10];
    }

    public Stack(int capacity) {
        this.stack = new int[capacity];
    }

    // Time: O(1); Space: O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    // Time: O(1); Space: O(1)
    public void push(int item) {
        if (count == stack.length)
            throw new StackOverflowError();
        stack[count++] = item;
    }

    // Time: O(1); Space: O(1)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return stack[--count];
    }

    // Time: O(1); Space: O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return stack[count - 1];
    }

    @Override
    // Time: O(n); Space: O(n)
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder str = new StringBuilder("[");
        for (int i = 0; ; i++) {
            str.append(stack[i]);
            if (i == count - 1)
                return str.append("]").toString();
            str.append(", ");
        }
    }
}

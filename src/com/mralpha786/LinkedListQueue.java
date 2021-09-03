package com.mralpha786;

import java.util.LinkedList;

public class LinkedListQueue {
    private final LinkedList<Integer> queue = new LinkedList<>();

    // Time: O(1); Space: O(1)
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Time: O(1); Space: O(1)
    public void enqueue(int item) {
        queue.addLast(item);
    }

    // Time: O(1); Space: O(1)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        return queue.removeFirst();
    }

    // Time: O(1); Space: O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return queue.getFirst();
    }

    // Time: O(1); Space: O(1)
    public int size() {
        return queue.size();
    }

    @Override
    // Time: O(n); Space: O(n)
    public String toString() {
        return queue.toString();
    }
}

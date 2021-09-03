package com.mralpha786.datastructures;

public class ArrayPriorityQueue {
    private final int[] queue; // Store all items in an array.
    private int count = 0;


    public ArrayPriorityQueue() { // Default Constructor;
        this.queue = new int[10];
    }

    public ArrayPriorityQueue(int capacity) {
        this.queue = new int[capacity];
    }

    // Time: O(1); Space:O(1)
    public boolean isFull() {
        return count == queue.length;
    }

    // Time: O(1); Space:O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    // Time: O(n); Space:O(1)
    public void add(int item) {
        if (isFull())
            throw new IndexOutOfBoundsException();

        int i;
        for (i = count - 1; i >= 0; i--)
            if (queue[i] < item)
                queue[i + 1] = queue[i];
            else
                break;
        queue[i + 1] = item;
        count++;
    }

    // Time: O(1); Space:O(1)
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[--count];
    }

    // Time: O(1); Space:O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[count - 1];
    }

    // Time: O(1); Space:O(1)
    public int size() {
        return count;
    }

    @Override
    // Time: O(n); Space:O(n)
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder str = new StringBuilder("[");
        for (int i = 0; ; i++) {
            str.append(queue[i]);
            if (i == count - 1)
                return str.append("]").toString();
            str.append(", ");
        }
    }
}

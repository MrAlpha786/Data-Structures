package com.mralpha786.datastructures;

public class ArrayQueue {
    private final int[] queue;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue() { // Default Constructor;
        this.queue = new int[10];
    }

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
    }

    // Time: O(1); Space: O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    // Time: O(1); Space: O(1)
    public boolean isFull() {
        return count == queue.length;
    }

    // Time: O(1); Space: O(1)
    public void enqueue(int item) {
        if (isFull())
            throw new IndexOutOfBoundsException();

        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        count++;
    }

    // Time: O(1); Space: O(1)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    // Time: O(1); Space: O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[front];
    }

    // Time: O(1); Space: O(1)
    public int size() {
        return count;
    }

    @Override
    // Time: O(n); Space: O(n)
    public String toString() {
        if (isEmpty())
            return "[]";

        final StringBuilder str = new StringBuilder("[");
        for (int i = front; ; ) {
            str.append(queue[i]);
            i = (i + 1) % queue.length;
            if (i == rear)
                return str.append("]").toString();
            str.append(", ");
        }
    }
}

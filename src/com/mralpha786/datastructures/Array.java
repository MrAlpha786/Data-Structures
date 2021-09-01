package com.mralpha786.datastructures;

import java.util.Arrays;

public class Array {
    private int[] items; // Store all items in an array;
    private int count = 0;

    public Array() {
        items = new int[10];
    }

    public Array(int initialCapacity) {
        items = new int[initialCapacity];
    }

    private void resizeItems() {
        // Resize items[] to double its size;
        items = Arrays.copyOf(items, items.length * 2);
    }

    // Time: O(n); Space: O(n)
    public void insert(int item) {
        if (count == items.length)
            resizeItems();
        items[count++] = item;
    }

    // Time: O(n); Space: O(n)
    public void insertAt(int index, int item) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        if (count == items.length)
            resizeItems();

        System.arraycopy(items, index, items, index + 1, count - index);
        items[index] = item;
        count++;
    }

    // Time: O(n); Space: O(1)
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    // Time: O(n); Space: O(1)
    public int indexOf(int item) {
        if (count == 0)
            throw new IllegalStateException();

        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    // Time: O(1); Space: O(1)
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(items, count));
    }
}

package com.mralpha786;

public class Array {
    private int[] items; // Store all items in an array;
    private int count = 0;

    public Array() {
        items = new int[10];
    } // Default Constructor;

    // The initial capacity does not represent the size of Array;
    public Array(int initialCapacity) {
        items = new int[initialCapacity];
    }

    // Resize items[] to double its size;
    // Time: O(n); Space: O(n)
    private void resizeItems() {
        int[] newItems = new int[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    // Time: O(n); Space: O(n)
    public void insert(int item) {
        if (count == items.length)
            resizeItems();
        items[count++] = item;
    }

    // Move other items to make space and insert item.
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

    // Remove the item and fill the void by moving other elements;
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

    // Time: O(n); Space: O(1)
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // Time: O(1); Space: O(1)
    public int size() {
        return count;
    }

    // Time: O(1); Space: O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    // Time: O(n); Space: O(n)
    public String toString() {
        if (count == 0)
            return "[]";

        StringBuilder str = new StringBuilder("[");
        for (int i = 0; ; i++) {
            str.append(items[i]);
            if (i == count - 1)
                return str.append(']').toString();
            str.append(", ");
        }
    }

    // <------------ Extras ------------>

    // Return max element in Array;
    // Time: O(n); Space: O(1)
    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        var max = items[0];
        for (int i = 1; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    // Return a new Array of intersected (common) items in this and other Array;
    // Time: O(n^2); Space: O(n)
    public Array intersect(Array other) {
        if (other == null)
            throw new IllegalArgumentException();

        Array newArray = new Array();
        for (int i = 0; i < other.count; i++)
            if (this.contains(other.items[i]))
                newArray.insert(other.items[i]);
        return newArray;
    }

    // Time: O(n); Space: O(1)
    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            var buffer = items[i];
            items[i] = items[count - 1 - i];
            items[count - 1 - i] = buffer;
        }
    }
}

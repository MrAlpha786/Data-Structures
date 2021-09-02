package com.mralpha786.datastructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int count = 0;

    // Return the node before the given node;
    // Time: O(n); Space: O(1)
    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != node)
            current = current.next;
        return current;
    }

    // Time: O(1); Space: O(1)
    public boolean isEmpty() {
        return first == null;
    }

    // Prepend item to list;
    // Time: O(1); Space: O(1)
    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        count++;
    }

    // Append item to list;
    // Time: O(1); Space: O(1)
    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        count++;
    }

    // Remove the first item and shift head to next item;
    // Time: O(1); Space: O(1)
    public int removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        var value = first.value;
        if (first == last)
            first = last = null;
        else
            first = first.next;
        count--;
        return value;
    }

    // Remove the last item and shift tail to previous item;
    // Time: O(n); Space: O(1)
    public int removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        var value = last.value;
        if (first == last)
            first = last = null;
        else {
            var previousNode = getPreviousNode(last);
            previousNode.next = null;
            last = previousNode;
        }
        count--;
        return value;
    }

    // Time: O(n); Space: O(1)
    public int indexOf(int item) {
        if (isEmpty())
            throw new NoSuchElementException();

        var current = first;
        var i = 0;
        while (current != null) {
            if (current.value == item)
                return i;
            current = current.next;
            i++;
        }
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

    @Override
    // Time: O(n); Space: O(n)
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder str = new StringBuilder("[");
        var current = first;
        while (true) {
            str.append(current.value);
            if (current.next == null)
                return str.append("]").toString();
            str.append(", ");
            current = current.next;
        }
    }

    // <------------ Extras ------------>

    // Convert this list to int[];
    // Time: O(n); Space: O(n)
    public int[] toArray() {
        int[] array = new int[count];
        var index = 0;
        var current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    // Time: O(n); Space: O(1)
    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    // Return Kth node from the end;
    // Time: O(n); Space: O(1)
    public int getKthFromEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new NullPointerException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    // Return int[] containing middle element (two element if size is even else one element);
    // Time: O(n); Space: O(1)
    public int[] getMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (count % 2 == 0)
            return new int[]{a.value, a.next.value};
        return new int[]{a.value};
    }

    // Create a loop to test hasLoop() method below;
    public void createLoop() {
        last.next = first;
    }

    // Check if list contains a loop;
    // Time: O(n); Space: O(1)
    public boolean hasLoop() {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (b.next == a || b == a)
                return true;
        }
        return false;
    }

    // Node
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

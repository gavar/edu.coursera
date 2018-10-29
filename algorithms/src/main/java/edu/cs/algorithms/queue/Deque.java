package edu.cs.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue
 * that supports adding and removing items from either the front or the back of the data structure.
 * <p>
 * Performance requirements.
 * Your deque implementation must support each deque operation (including construction) in constant worst-case time.
 * A deque containing n items must use at most 48n + 192 bytes of memory and use space proportional to the number
 * of items currently in the deque. Additionally, your iterator implementation must support each operation
 * (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> node;

    /** Construct an empty deque. */
    public Deque() {
        size = 0;
    }

    /** Is the deque empty?. */
    public boolean isEmpty() {
        return size < 1;
    }

    /** Number of items on the deque. */
    public int size() {
        return size;
    }

    /** Add the item to the front. */
    public void addFirst(Item item) {
        Node<Item> first = new Node<>(item);
        if (node == null) {
            node = first;
            node.prev = first;
        } else {
            first.prev = node.prev;
            first.next = node;
            node.prev = first;
            node = first;
        }
        size++;
    }

    /** Add the item to the end. */
    public void addLast(Item item) {
        Node<Item> last = new Node<>(item);
        if (node == null) {
            node = last;
            node.prev = last;
        } else {
            last.prev = node.prev;
            node.prev.next = last;
            node.prev = last;
        }
        size++;
    }

    /** Remove and return the item from the front. */
    public Item removeFirst() {
        this.validateNotEmpty();
        Node<Item> first = node;
        node = node.next;
        size--;
        return first.value;
    }

    /** Remove and return the item from the end. */
    public Item removeLast() {
        this.validateNotEmpty();
        Node<Item> last = node.prev;
        node.prev = last.prev;
        size--;
        return last.value;
    }

    /** Iterator over items in order from front to end. */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>(this.node);
    }

    private void validateNotEmpty() {
        if (size < 1)
            throw new NoSuchElementException("Deque is empty");
    }

    private static class Node<T> {
        final T value;
        Node<T> prev, next;

        Node(T value) {
            if (value == null)
                throw new IllegalArgumentException("value cannot be null");

            this.value = value;
        }
    }

    private static class DequeIterator<T> implements Iterator<T> {

        private Node<T> node;

        public DequeIterator(Node<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (node == null)
                throw new NoSuchElementException();

            T value = node.value;
            node = node.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}

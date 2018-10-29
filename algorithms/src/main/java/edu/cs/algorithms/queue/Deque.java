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
    private Node<Item> first;
    private Node<Item> last;

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
        Node<Item> node = new Node<>(item);
        node.next = first;
        if (++size < 2) last = first = node;
        else first.prev = first = node;
    }

    /** Add the item to the end. */
    public void addLast(Item item) {
        Node<Item> node = new Node<>(item);
        node.prev = last;
        if (++size < 2) first = last = node;
        else last.next = last = node;
    }

    /** Remove and return the item from the front. */
    public Item removeFirst() {
        this.validateNotEmpty();
        Node<Item> node = first;
        first = first.next;
        if (--size > 0) first.prev = null;
        else first = last = null;
        return node.item;
    }

    /** Remove and return the item from the end. */
    public Item removeLast() {
        this.validateNotEmpty();
        Node<Item> node = last;
        last = last.prev;
        if (--size < 1) first = last = null;
        else last.next = null;
        return node.item;
    }

    /** Iterator over items in order from front to end. */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>(first);
    }

    private void validateNotEmpty() {
        if (size < 1)
            throw new NoSuchElementException("Deque is empty");
    }

    private static class Node<T> {
        final T item;
        Node<T> prev, next;

        Node(T item) {
            if (item == null)
                throw new IllegalArgumentException("item cannot be null");

            this.item = item;
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

            T item = node.item;
            node = node.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}

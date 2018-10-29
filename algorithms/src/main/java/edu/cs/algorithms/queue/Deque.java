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
public class Deque<T> implements Iterable<T> {

    /** Construct an empty deque. */
    public Deque() {

    }

    /** Is the deque empty?. */
    public boolean isEmpty() {
        return true;
    }

    /** Number of items on the deque. */
    public int size() {
        return 0;
    }

    /** Add the item to the front. */
    public void addFirst(T item) throws IllegalArgumentException {

    }

    /** Add the item to the end. */
    public void addLast(T item) throws IllegalArgumentException {

    }

    /** Remove and return the item from the front. */
    public T removeFirst() throws NoSuchElementException {
        return null;
    }

    /** Remove and return the item from the end. */
    public T removeLast() {
        return null;
    }

    /** Iterator over items in order from front to end. */
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static class DequeIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() throws NoSuchElementException {
            return null;
        }

        @Override
        public void remove() throws UnsupportedOperationException {

        }
    }
}

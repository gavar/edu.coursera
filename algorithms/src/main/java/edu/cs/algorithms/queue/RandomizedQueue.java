package edu.cs.algorithms.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A randomized queue is similar to a stack or queue, except that the item removed
 * is chosen uniformly at random from items in the data structure.
 * <p>
 * Performance requirements.
 * Your randomized queue implementation must support each randomized queue operation (besides creating an iterator)
 * in constant amortized time. That is, any sequence of m randomized queue operations (starting from an empty queue)
 * must take at most cm steps in the worst case, for some constant c. A randomized queue containing n items must use
 * at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support operations next() and
 * hasNext() in constant worst-case time; and construction in linear time; you may (and will need to) use a linear
 * amount of extra memory per iterator.
 */
public class RandomizedQueue<T> implements Iterable<T> {

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
    }

    /** Is the randomized queue empty?. */
    public boolean isEmpty() {
        return true;
    }

    /** Number of items on the randomized queue. */
    public int size() {
        return 0;
    }

    /** Add the item. */
    public void enqueue(T item) throws IllegalArgumentException {
    }

    /** Remove and return a random item. */
    public T dequeue() throws NoSuchElementException {
        return null;
    }

    /** Return a random item (but do not remove it). */
    public T sample() throws NoSuchElementException {
        return null;
    }

    /** Independent iterator over items in random order */
    public Iterator<T> iterator() {
        return null;
    }

    private static class RandomizedQueueIterator<T> implements Iterator<T> {

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

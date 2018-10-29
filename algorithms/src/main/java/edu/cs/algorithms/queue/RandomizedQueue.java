package edu.cs.algorithms.queue;

import edu.princeton.cs.algs4.StdRandom;

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
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private Item[] items;

    /** Construct an empty randomized queue. */
    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    @SuppressWarnings("unchecked")
    private RandomizedQueue(Item[] items, int size) {
        this.size = size;
        this.items = (Item[]) new Object[size];
        System.arraycopy(items, 0, this.items, 0, size);
    }

    /** Is the randomized queue empty?. */
    public boolean isEmpty() {
        return size < 1;
    }

    /** Number of items on the randomized queue. */
    public int size() {
        return size;
    }

    /** Add the item. */
    public void enqueue(Item item) throws IllegalArgumentException {
        if (item == null)
            throw new IllegalArgumentException();

        grow(size + 1);
        items[size++] = item;
    }

    /** Remove and return a random item. */
    public Item dequeue() throws NoSuchElementException {
        if (size < 1)
            throw new NoSuchElementException();

        int index = StdRandom.uniform(0, size);
        Item value = items[index];
        items[index] = items[--size]; // take last item
        items[size] = null; // remove reference to last item
        shrink(); // shrink if required

        return value;
    }

    /** Return a random item (but do not remove it). */
    public Item sample() throws NoSuchElementException {
        if (size < 1)
            throw new NoSuchElementException();

        int index = StdRandom.uniform(0, size);
        return items[index];
    }

    @SuppressWarnings("unchecked")
    private void grow(int capacity) {
        if (items.length < capacity) {
            Item[] buffer = (Item[]) new Object[items.length * 2];
            if (size >= 0) System.arraycopy(items, 0, buffer, 0, size);
            this.items = buffer;
        }
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        if (size < items.length / 4) {
            Item[] buffer = (Item[]) new Object[items.length / 4];
            if (size >= 0) System.arraycopy(items, 0, buffer, 0, size);
            this.items = buffer;
        }
    }

    /** Independent iterator over items in random order */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>(items, size);
    }

    private static class RandomizedQueueIterator<T> implements Iterator<T> {

        private final RandomizedQueue<T> rq;

        RandomizedQueueIterator(T[] items, int size) {
            rq = new RandomizedQueue<>(items, size);
        }

        @Override
        public boolean hasNext() {
            return !rq.isEmpty();
        }

        @Override
        public T next() throws NoSuchElementException {
            return rq.dequeue();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("remove");
        }
    }
}

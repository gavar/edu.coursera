package edu.cs.algorithms.queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    @ParameterizedTest
    @MethodSource("data")
    public void iterateFIFO(List<String> items) {
        // initialize
        Deque<String> deque = new Deque<>();
        for (String item : items) deque.addLast(item);

        // iterate
        Iterator<String> iterator = deque.iterator();
        for (int i = 0; i < items.size(); i++) {
            String actual = iterator.next();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertFalse(iterator.hasNext(), "iterator should be empty");
    }

    @ParameterizedTest
    @MethodSource("data")
    public void iterateLIFO(List<String> items) {
        // initialize
        Deque<String> deque = new Deque<>();
        for (String item : items) deque.addFirst(item);

        // iterate
        Iterator<String> iterator = deque.iterator();
        for (int i = items.size() - 1; i >= 0; i--) {
            String actual = iterator.next();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertFalse(iterator.hasNext(), "iterator should be empty");
    }

    @ParameterizedTest
    @MethodSource("data")
    public void addFirstRemoveFirst(List<String> items) {
        // initialize
        Deque<String> deque = new Deque<>();
        for (String item : items) deque.addFirst(item);

        // LIFO
        for (int i = items.size() - 1; i >= 0; i--) {
            String actual = deque.removeFirst();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertTrue(deque.isEmpty(), "deque should be empty");
        assertEquals(deque.size(), 0, "deque size should be 0");
    }

    @ParameterizedTest
    @MethodSource("data")
    public void addLastRemoveLast(List<String> items) {
        // initialize
        Deque<String> deque = new Deque<>();
        for (String item : items) deque.addLast(item);

        // LIFO
        for (int i = items.size() - 1; i >= 0; i--) {
            String actual = deque.removeLast();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertTrue(deque.isEmpty(), "deque should be empty");
        assertEquals(deque.size(), 0, "deque size should be 0");
    }

    @ParameterizedTest
    @MethodSource("data")
    public void addFirstRemoveLast(List<String> items) {
        // initialize
        Deque<String> deque = new Deque<>();
        for (String item : items) deque.addFirst(item);

        // FIFO
        for (int i = 0; i < items.size(); i++) {
            String actual = deque.removeLast();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertTrue(deque.isEmpty(), "deque should be empty");
        assertEquals(deque.size(), 0, "deque size should be 0");
    }

    @ParameterizedTest
    @MethodSource("data")
    public void addLastRemoveFirst(List<String> items) {
        Deque<String> deque = new Deque<>();

        // initialize
        for (String item : items)
            deque.addLast(item);

        // FIFO
        for (int i = 0; i < items.size(); i++) {
            String actual = deque.removeFirst();
            String expect = items.get(i);
            assertEquals(expect, actual);
        }

        assertTrue(deque.isEmpty(), "deque should be empty");
        assertEquals(deque.size(), 0, "deque size should be 0");
    }

    @Test
    private static List[] data() {
        return new List[]{
                Arrays.asList("A"),
                Arrays.asList("A", "B"),
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I"),
        };
    }
}

package edu.cs.algorithms.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedQueueTest {

    @ParameterizedTest
    @MethodSource("data")
    void iterate(List<String> items) {
        // initialize
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        for (String item : items) queue.enqueue(item);

        // process
        for (String item : queue)
            assertTrue(items.remove(item), "item should not occur more than once");

        assertTrue(items.isEmpty(), "should iterate all of the items");
    }

    @ParameterizedTest
    @MethodSource("data")
    void dequeueUntilEmpty(List<String> items) {
        // initialize
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        for (String item : items) queue.enqueue(item);

        // process
        while (!queue.isEmpty()) {
            String item = queue.dequeue();
            assertTrue(items.remove(item), "item should not occur more than once");
            assertEquals(items.size(), queue.size(), "size mismatch");
        }

        assertTrue(items.isEmpty(), "should remove all the items");
    }

    private static List[] data() {
        return new List[]{
                Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I"),
                Arrays.asList("AA", "BB", "BB", "BB", "BB", "BB", "CC", "CC"),
        };
    }
}

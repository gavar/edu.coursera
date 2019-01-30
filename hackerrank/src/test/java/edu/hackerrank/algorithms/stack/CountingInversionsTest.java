package edu.hackerrank.algorithms.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestRectangleTest {

    @ParameterizedTest
    @MethodSource("data")
    void largestRectangle(String fileName, long expect) throws IOException {
        int[] array = parse(fileName);
        long actual = LargestRectangle.largestRectangle(array);
        assertEquals(expect, actual);
    }

    private int[] parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();

        return array;
    }

    private static Object[][] data() {
        return new Object[][]{
                new Object[]{"algorithms/stack/largest-rectangle-0.txt", 9},
                new Object[]{"algorithms/stack/largest-rectangle-1.txt", 26152},
                new Object[]{"algorithms/stack/largest-rectangle-3.txt", 51060},
                new Object[]{"algorithms/stack/largest-rectangle-11.txt", 11828396},
                new Object[]{"algorithms/stack/largest-rectangle-14.txt", 18},
                new Object[]{"algorithms/stack/largest-rectangle-15.txt", 50},
        };
    }
}

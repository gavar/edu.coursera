package edu.hackerrank.algorithms.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarArraySumTest {

    @ParameterizedTest
    @MethodSource("data")
    void maxSubsetSum(String fileName, long expect) throws IOException {
        int[] array = parse(fileName);
        long actual = MaxArraySum.maxSubsetSum(array);
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
                new Object[]{"algorithms/dynamic/max-array-sum-0.txt", 151598486},
                new Object[]{"algorithms/dynamic/max-array-sum-30.txt", 13},
                new Object[]{"algorithms/dynamic/max-array-sum-31.txt", 11},
                new Object[]{"algorithms/dynamic/max-array-sum-32.txt", 15},
        };
    }
}

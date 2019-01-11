package edu.hackerrank.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingInversionsTest {

    @ParameterizedTest
    @MethodSource("data")
    void countingInversions(String fileName, long[] expects) throws IOException {
        Problem[] problems = parse(fileName);
        for (int i = 0; i < problems.length; i++) {
            Problem problem = problems[i];
            long expect = expects[i];
            long actual = CountingInversions.countInversions(problem.array);
            assertEquals(expect, actual, "case #" + (i + 1));
        }
    }

    private Problem[] parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        Problem[] problems = new Problem[scanner.nextInt()];
        for (int n = 0; n < problems.length; n++) {
            int[] array = new int[scanner.nextInt()];
            for (int i = 0; i < array.length; i++)
                array[i] = scanner.nextInt();

            Problem problem = new Problem();
            problem.array = array;
            problems[n] = problem;
        }

        return problems;
    }

    private class Problem {
        int array[];
    }

    private static Object[][] data() {
        return new Object[][]{
                new Object[]{"algorithms/sorting/counting-inversions-0.txt", new long[]{0, 4}},
                new Object[]{"algorithms/sorting/counting-inversions-14.txt", new long[]{1, 6}},
                new Object[]{"algorithms/sorting/counting-inversions-15.txt", new long[]{0, 3}},
        };
    }
}

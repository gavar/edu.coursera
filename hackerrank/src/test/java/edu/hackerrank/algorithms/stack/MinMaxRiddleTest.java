package edu.hackerrank.algorithms.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinMaxRiddleTest {

    @ParameterizedTest
    @MethodSource("data")
    void solve(String fileName) throws IOException {
        Problem problem = parse(fileName);
        long[] expect = problem.expect;
        long[] actual = MinMaxRiddle.solve(problem.array);
        assertArrayEquals(expect, actual);
    }

    private Problem parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        int N = scanner.nextInt();
        Problem problem = new Problem();
        problem.array = new long[N];
        problem.expect = new long[N];

        for (int i = 0; i < N; i++)
            problem.array[i] = scanner.nextLong();

        for (int i = 0; i < N; i++)
            problem.expect[i] = scanner.nextLong();

        return problem;
    }

    private class Problem {
        long[] array;
        long[] expect;
    }

    private static String[] data() {
        return new String[]{
                "algorithms/stack/min-max-riddle-6.txt",
                "algorithms/stack/min-max-riddle-7.txt",
                "algorithms/stack/min-max-riddle-8.txt",
        };
    }
}

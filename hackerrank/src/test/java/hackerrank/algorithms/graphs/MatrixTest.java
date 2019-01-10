package hackerrank.algorithms.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    @ParameterizedTest
    @MethodSource("data")
    void minTime(String fileName, int expect) throws IOException {
        Problem problem = parse(fileName);
        int actual = Matrix.minTime(problem.roads, problem.machines);
        assertEquals(expect, actual);
    }

    private Problem parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner sc = new Scanner(url.openStream());

        int n = sc.nextInt(); // number of cities
        int k = sc.nextInt(); // number of machines

        int[][] roads = new int[n - 1][];
        for (int i = 0; i < n - 1; i++)
            roads[i] = new int[]{
                    sc.nextInt(),
                    sc.nextInt(),
                    sc.nextInt(),
            };

        int[] machines = new int[k];
        for (int i = 0; i < k; i++)
            machines[i] = sc.nextInt();

        Problem problem = new Problem();
        problem.machines = machines;
        problem.roads = roads;
        return problem;
    }

    private class Problem {
        int[][] roads;
        int[] machines;
    }

    private static Object[][] data() {
        return new Object[][]{
                new Object[]{"algorithms/graphs/matrix-0.txt", 10},
                new Object[]{"algorithms/graphs/matrix-1.txt", 55},
                new Object[]{"algorithms/graphs/matrix-8.txt", 3105329},
                new Object[]{"algorithms/graphs/matrix-9.txt", 1738531},
                new Object[]{"algorithms/graphs/matrix-10.txt", 5},
                new Object[]{"algorithms/graphs/matrix-11.txt", 8},
        };
    }
}

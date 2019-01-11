package hackerrank.algorithms.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleSumTest {

    @ParameterizedTest
    @MethodSource("data")
    void triplets(String fileName, long expect) throws IOException {
        Problem p = parse(fileName);
        long actual = TripleSum.triplets(p.a, p.b, p.c);
        assertEquals(expect, actual);
    }

    private Problem parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        Problem p = new Problem();
        p.a = new int[scanner.nextInt()];
        p.b = new int[scanner.nextInt()];
        p.c = new int[scanner.nextInt()];

        for (int i = 0; i < p.a.length; i++) p.a[i] = scanner.nextInt();
        for (int i = 0; i < p.b.length; i++) p.b[i] = scanner.nextInt();
        for (int i = 0; i < p.c.length; i++) p.c[i] = scanner.nextInt();

        return p;
    }

    private class Problem {
        int[] a, b, c;
    }

    private static Object[][] data() {
        return new Object[][]{
                new Object[]{"algorithms/search/triple-sum-0.txt", 8},
                new Object[]{"algorithms/search/triple-sum-1.txt", 5},
                new Object[]{"algorithms/search/triple-sum-4.txt", 145333908482693L},
                new Object[]{"algorithms/search/triple-sum-8.txt", 12603652660415L},
                new Object[]{"algorithms/search/triple-sum-9.txt", 12},
        };
    }
}

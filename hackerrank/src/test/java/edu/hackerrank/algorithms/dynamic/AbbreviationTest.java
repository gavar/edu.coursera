package edu.hackerrank.algorithms.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbbreviationTest {

    @ParameterizedTest
    @MethodSource("data")
    void abbreviation(String fileName) throws IOException {
        Problem[] problems = parse(fileName);
        for (int i = 0; i < problems.length; i++) {
            Problem problem = problems[i];
            String a = problem.a;
            String b = problem.b;
            String expect = problem.expect;
            String actual = Abbreviation.abbreviation(a, b);
            assertEquals(expect, actual, String.format("case #%s\na: %s\nb: %s", i + 1, a, b));
        }
    }

    private Problem[] parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner scanner = new Scanner(url.openStream());

        Problem[] array = new Problem[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Problem();
            array[i].a = scanner.next();
            array[i].b = scanner.next();
        }

        for (Problem problem : array)
            problem.expect = scanner.next();

        return array;
    }

    private class Problem {
        String a;
        String b;
        String expect;
    }

    private static String[] data() {
        return new String[]{
                "algorithms/dynamic/abbreviation-0.txt",
                "algorithms/dynamic/abbreviation-1.txt",
                "algorithms/dynamic/abbreviation-6.txt",
                "algorithms/dynamic/abbreviation-15.txt",
        };
    }
}

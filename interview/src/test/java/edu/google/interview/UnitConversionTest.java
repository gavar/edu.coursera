package edu.google.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConversionTest {

    @ParameterizedTest
    @MethodSource("data")
    void convert(String fileName) throws IOException {
        Problem p = parse(fileName);
        double[] outputs = UnitConversion.convert(p.sources, p.ratios, p.destinations, p.queries);
        for (int i = 0; i < p.expects.length; i++) {
            double expect = p.expects[i];
            double actual = (int) (outputs[i] * 100) * 0.01;
            assertEquals(expect, actual);
        }
    }

    private Problem parse(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        Scanner sc = new Scanner(url.openStream());

        int n = sc.nextInt();
        Problem p = new Problem();
        p.ratios = new double[n];
        p.sources = new String[n];
        p.destinations = new String[n];
        for (int i = 0; i < n; i++) {
            p.sources[i] = sc.next();
            p.ratios[i] = sc.nextDouble();
            p.destinations[i] = sc.next();
        }

        int q = sc.nextInt();
        p.queries = new String[q][];
        p.expects = new double[q];
        for (int i = 0; i < q; i++) {
            p.queries[i] = new String[2];
            p.queries[i][0] = sc.next();
            p.expects[i] = sc.nextDouble();
            p.queries[i][1] = sc.next();
        }

        return p;
    }

    private class Problem {
        String[] sources;
        String[] destinations;
        double[] ratios;
        String[][] queries;
        double expects[];
    }

    private static String[] data() {
        return new String[]{
                "edu/google/interview/unit-conversion-1.txt",
        };
    }
}

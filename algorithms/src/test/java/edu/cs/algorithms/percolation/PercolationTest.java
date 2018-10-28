package edu.cs.algorithms.percolation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PercolationTest {

    @ParameterizedTest
    @CsvSource({
            "percolation/input1.txt",
            "percolation/input2.txt",
            "percolation/input3.txt",
            "percolation/input4.txt",
            "percolation/input5.txt",
            "percolation/input6.txt",
            "percolation/input7.txt",
            "percolation/input8.txt",
            "percolation/input8-dups.txt",
            "percolation/input10.txt",
            "percolation/input20.txt",
            "percolation/input50.txt",
            "percolation/java60.txt",
            "percolation/jerry47.txt",
            "percolation/sedgewick60.txt",
            "percolation/snake13.txt",
            "percolation/snake101.txt",
            "percolation/wayne98.txt",
    })
    public void shouldPercolate(String fileName) throws IOException {
        Percolation percolation = fromFile(fileName);
        assertTrue(percolation.percolates());
    }

    @ParameterizedTest
    @CsvSource({
            "percolation/greeting57.txt",
            "percolation/heart25.txt",
            "percolation/input1-no.txt",
            "percolation/input2-no.txt",
            "percolation/input8-no.txt",
            "percolation/input10-no.txt",
    })
    public void shouldNotPercolate(String fileName) throws IOException {
        Percolation percolation = fromFile(fileName);
        assertFalse(percolation.percolates());
    }

    public Percolation fromFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        try (Scanner scanner = new Scanner(url.openStream())) {
            int size = scanner.nextInt();
            Percolation percolation = new Percolation(size);
            while (scanner.hasNext()) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                percolation.open(row, col);
            }
            return percolation;
        }
    }
}

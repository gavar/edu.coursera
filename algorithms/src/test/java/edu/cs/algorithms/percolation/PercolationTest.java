package edu.cs.algorithms.percolation;

import edu.princeton.cs.algs4.StdIn;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
        Scanner scanner = scannerOf(fileName);
        final int size = scanner.nextInt();
        Percolation percolation = fill(scanner, size);
        boolean percolates = percolation.percolates();
        boolean backWash = isBackWash(fileName, percolation, size);
        if (!percolates || backWash) draw(percolation, size);
        assertTrue(percolates);
        assertFalse(backWash);
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
        Scanner scanner = scannerOf(fileName);
        final int size = scanner.nextInt();
        Percolation percolation = fill(scanner, size);
        boolean percolates = percolation.percolates();
        boolean backWash = isBackWash(fileName, percolation, size);
        if (percolates || backWash) draw(percolation, size);
        assertFalse(percolates);
        assertFalse(backWash);

    }

    public boolean isBackWash(String fileName, Percolation p, int size) {
        switch (fileName) {
            case "percolation/input10.txt":
                return isAnyFull(p, size, 1, 2, 8);
            case "percolation/input20.txt":
                return isAnyFull(p, size, 1);
            case "percolation/input50.txt":
                return isAnyFull(p, size, 1, 3, 5, 6, 8, 21, 22, 23, 24, 27, 28, 30, 32, 33, 34, 35, 37, 40, 41, 44, 45, 46, 47, 48, 49, 50);
            case "percolation/sedgewick60.txt":
                return isAnyFull(p, size, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37);
        }
        return false;
    }

    public boolean isAnyFull(Percolation p, int row, int... cols) {
        for (int col : cols)
            if (p.isFull(row, col))
                return true;
        return false;
    }

    public void draw(Percolation percolation, int size) {
        PercolationVisualizer.draw(percolation, size);
        StdIn.readLine();
    }

    public Scanner scannerOf(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        return new Scanner(url.openStream());
    }

    public Percolation fill(Scanner scanner, int size) {
        Set<Integer> sites = new HashSet<>();
        Percolation percolation = new Percolation(size);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            percolation.open(row, col); // open
            sites.add((row - 1) * size + (col - 1)); // track unique sites
            assertTrue(percolation.isOpen(row, col), "site should be marked as open");
            assertEquals(sites.size(), percolation.numberOfOpenSites(), "open sites number does not match");
        }
        return percolation;
    }
}

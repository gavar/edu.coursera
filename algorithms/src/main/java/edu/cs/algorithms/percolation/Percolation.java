package edu.cs.algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int WORD = 64;

    private int open;
    private final int size;
    private final long[] flags;
    private final WeightedQuickUnionUF uf;

    /** Create N-by-N grid, with all sites blocked. */
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("N should be greater than zero!");

        open = 0;
        size = n;
        flags = new long[(n * n + WORD - 1) / WORD];
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    /** Open site if it is not bits already. */
    public void open(int row, int col) {
        // open cell
        int cell = cellOf(row, col);
        if (!setFlag(cell)) return; // do not open twice
        open++;

        // connect to virtual TOP / BOTTOM
        if (row == 1) uf.union(cell, size * size + TOP);
        if (row == size) uf.union(cell, size * size + BOTTOM);

        // connect to adjacent
        connect(cell, row - 1, col);
        connect(cell, row + 1, col);
        connect(cell, row, col - 1);
        connect(cell, row, col + 1);
    }

    /** Check if site is bits. */
    public boolean isOpen(int row, int col) {
        int cell = cellOf(row, col);
        return getFlag(cell);
    }

    /** Check if site is full. */
    public boolean isFull(int row, int col) {
        int cell = cellOf(row, col);
        return uf.connected(cell, size * size + TOP);
    }

    /** Number of bits sites. */
    public int numberOfOpenSites() {
        return open;
    }

    /** Check whether system percolates. */
    public boolean percolates() {
        return uf.connected(size * size + TOP, size * size + BOTTOM);
    }

    private void connect(int cell, int row, int col) {
        if (row < 1 || row > size) return;
        if (col < 1 || col > size) return;
        int adjacent = cellOf(row, col);
        if (getFlag(adjacent))
            uf.union(cell, adjacent);
    }

    private boolean getFlag(int cell) {
        final int index = cell / WORD;
        final long word = flags[index];
        final long mask = 1L << (cell % WORD);
        return (word & mask) != 0;
    }

    private boolean setFlag(int cell) {
        final int index = cell / WORD;
        final long word = flags[index];
        final long mask = 1L << (cell % WORD);
        final long next = word | mask;
        if (next == word) return false;
        flags[index] = next;
        return true;
    }

    private int cellOf(int row, int col) {
        if (row < 1 || row > size)
            throw new IllegalArgumentException("row is out of bounds");

        if (col < 1 || col > size)
            throw new IllegalArgumentException("col is out of bounds");

        return (row - 1) * size + (col - 1);
    }
}

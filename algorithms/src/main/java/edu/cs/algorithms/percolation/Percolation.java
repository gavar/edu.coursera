package edu.cs.algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.BitSet;

public class Percolation {

    int open;
    final BitSet bits;
    final int size, top, bottom;
    final WeightedQuickUnionUF uf;

    /** Create N-by-N grid, with all sites blocked. */
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("N should be greater than zero!");

        size = n;
        top = n * n;
        bottom = n * n + 1;
        bits = new BitSet(n * n);
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    /** Open site if it is not bits already. */
    public void open(int row, int col) {
        // open cell
        int cell = cellOf(row, col);
        bits.set(cell);

        // connect to virtual TOP / BOTTOM
        if (row == 1) uf.union(cell, top);
        if (row == size) uf.union(cell, bottom);

        // connect to adjacent
        connect(cell, row - 1, col);
        connect(cell, row + 1, col);
        connect(cell, row, col - 1);
        connect(cell, row, col + 1);
    }

    /** Check if site is bits. */
    public boolean isOpen(int row, int col) {
        int cell = cellOf(row, col);
        return bits.get(cell);
    }

    /** Check if site is full. */
    public boolean isFull(int row, int col) {
        int cell = cellOf(row, col);
        return uf.connected(cell, top) &&
                uf.connected(cell, bottom);
    }

    /** Number of bits sites. */
    public int numberOfOpenSites() {
        return open;
    }

    /** Check whether system percolates. */
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    private void connect(int cell, int row, int col) {
        if (row < 1 || row > size) return;
        if (col < 1 || col > size) return;
        int adjacent = cellOf(row, col);
        if (bits.get(adjacent))
            uf.union(cell, adjacent);
    }

    private int cellOf(int row, int col) {
        if (row < 1 || row > size)
            throw new IndexOutOfBoundsException("row is out of bounds");

        if (col < 1 || col > size)
            throw new IndexOutOfBoundsException("col is out of bounds");

        return (row - 1) * size + (col - 1);
    }
}

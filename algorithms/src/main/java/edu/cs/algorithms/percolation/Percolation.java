package edu.cs.algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int WORD = 8;

    private int count = 0;
    private final int size;
    private final byte[] open;
    private final byte[] flow;
    private final WeightedQuickUnionUF uf;

    /** Create N-by-N grid, with all sites blocked. */
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("N should be greater than zero!");

        int memory = n * n + 1;
        int bytes = (memory + WORD - 1) / WORD;

        size = n;
        open = new byte[bytes];
        flow = new byte[bytes];
        uf = new WeightedQuickUnionUF(memory);
    }

    /** Open site if it is not bits already. */
    public void open(int row, int col) {
        // mark as open
        int index = indexOf(row, col);
        if (!setFlag(open, index)) return;
        count++;

        // remember if current component connected to bottoms
        int root = uf.find(index);
        boolean flowing = getFlag(flow, root);

        // connect to virtual TOP
        if (row == 1)
            uf.union(0, index);

        // connect to adjacent and track if any cell connected to bottom
        if (connect(index, row, col - 1)) flowing = true;
        if (connect(index, row, col + 1)) flowing = true;
        if (connect(index, row - 1, col)) flowing = true;
        if (connect(index, row + 1, col)) flowing = true;

        // if any of the component node connects to bottom,
        // then every component node connects to the bottom
        if (flowing || row == size) {
            root = uf.find(index);
            setFlag(flow, root);
        }
    }

    /** Check if site is bits. */
    public boolean isOpen(int row, int col) {
        int index = indexOf(row, col);
        return getFlag(open, index);
    }

    /** Check if site is full. */
    public boolean isFull(int row, int col) {
        int index = indexOf(row, col);
        return uf.connected(0, index);
    }

    /** Number of bits sites. */
    public int numberOfOpenSites() {
        return count;
    }

    /** Check whether system percolates. */
    public boolean percolates() {
        int root = uf.find(0);
        return getFlag(flow, root);
    }

    private boolean connect(int index, int row, int col) {
        if (row < 1 || row > size) return false;
        if (col < 1 || col > size) return false;
        return connect(index, indexOf(row, col));
    }

    private boolean connect(int index, int adjacent) {
        // connect only with open cells
        // can't be connected to bottom if closed
        if (!getFlag(this.open, adjacent))
            return false;

        // connect to root since we already found it making tree more compact
        int root = uf.find(adjacent);
        boolean flowing = getFlag(flow, root);
        uf.union(index, root);
        return flowing;
    }

    private static boolean getFlag(byte[] flags, int index) {
        final int mask = 1 << (index % WORD);
        final int word = flags[index / WORD];
        return (word & mask) != 0;
    }

    private static boolean setFlag(byte[] flags, int index) {
        final int mask = 1 << index % WORD;
        final int word = flags[index / WORD];
        final int next = word | mask;
        if (next == word) return false;
        flags[index / WORD] = (byte) next;
        return true;
    }

    private int indexOf(int row, int col) {
        if (row < 1 || row > size)
            throw new IllegalArgumentException("row is out of bounds");

        if (col < 1 || col > size)
            throw new IllegalArgumentException("col is out of bounds");

        return (row - 1) * size + col; // (0;0) is virtual top
    }
}

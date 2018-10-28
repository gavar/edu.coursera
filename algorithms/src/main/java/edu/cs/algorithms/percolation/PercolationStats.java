package edu.cs.algorithms.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    /**
     * Perform trials independent experiments on an N-by-N grid.
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("n should be greater than zero");
        if (trials <= 0) throw new IllegalArgumentException("trails should be greater than zero");

        double size = n * n;
        double[] values = new double[trials];
        for (int t = 0; t < trials; t++) {
            int count = 0;
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int i = 1 + StdRandom.uniform(n);
                int j = 1 + StdRandom.uniform(n);
                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    count++;
                }
            }
            values[t] = count / size;
        }

        mean = StdStats.mean(values);
        stddev = StdStats.stddev(values);
        double dev = 1.96 * stddev / Math.sqrt(trials);
        confidenceLo = mean - dev;
        confidenceHi = mean + dev;
    }

    /** Sample mean of percolation threshold. */
    public double mean() {
        return mean;
    }

    /** Sample standard deviation of percolation threshold. */
    public double stddev() {
        return stddev;
    }

    /** Low endpoint of 95% confidence interval. */
    public double confidenceLo() {
        return confidenceLo;
    }

    /** High endpoint of 95% confidence interval. */
    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("invalid number arguments");

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, t);

        StdOut.println(String.format("mean                    = %s", stats.mean()));
        StdOut.println(String.format("stddev                  = %s", stats.stddev()));
        StdOut.println(String.format("95%% confidence interval = [%s, %s]", stats.confidenceLo(), stats.confidenceHi()));
    }
}

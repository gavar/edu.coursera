package edu.hackerrank.algorithms.search;

import java.util.Arrays;

/**
 * Given 3 arrays a, b, c of different sizes, find the number of distinct triplets (p, q, r), where
 * p - is an element of a, q is an element of b, r - is an element of c, satisfying the criteria:
 * p <= q AND q >= r.
 * https://www.hackerrank.com/challenges/triple-sum
 */
public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        a = Arrays.stream(a).distinct().sorted().toArray();
        b = Arrays.stream(b).distinct().sorted().toArray();
        c = Arrays.stream(c).distinct().sorted().toArray();

        long total = 0;
        int p = a.length - 1;
        int q = b.length - 1;
        int r = c.length - 1;
        while (p >= 0 && q >= 0 && r >= 0) {
            if (a[p] > b[q]) p--;
            else if (c[r] > b[q]) r--;
            else {
                total += (1L + p) * (1L + r);
                q--;
            }
        }
        return total;
    }
}

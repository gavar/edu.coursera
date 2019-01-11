package edu.hackerrank.algorithms.sorting;

/**
 * Merge Sort: Counting Inversions.
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 */
class CountingInversions {

    static long countInversions(int[] arr) {
        long swaps = sort(arr, 0, arr.length, new int[arr.length]);
        assert isSorted(arr);
        return swaps;
    }

    private static long sort(int[] arr, int lo, int hi, int[] aux) {
        long count = 0L;
        if (lo < hi - 1) {
            int half = (hi + lo) / 2;
            count += sort(arr, lo, half, aux);
            count += sort(arr, half, hi, aux);
            count += merge(arr, lo, half, hi, aux);
        }
        return count;
    }

    private static long merge(int[] arr, int lo, int half, int hi, int[] aux) {
        int i = lo;
        int l = lo;
        int h = half;
        long count = 0;

        while (l < half && h < hi) {
            if (arr[l] > arr[h]) {
                aux[i++] = arr[h++];
                count += half - l;
            } else {
                aux[i++] = arr[l++];
            }
        }

        System.arraycopy(arr, l, aux, i, half - l);
        System.arraycopy(arr, h, aux, i, hi - h);
        System.arraycopy(aux, lo, arr, lo, hi - lo);
        return count;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }
}

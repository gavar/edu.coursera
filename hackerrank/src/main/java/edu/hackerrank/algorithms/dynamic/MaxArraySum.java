package edu.hackerrank.algorithms.dynamic;

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
 * https://www.hackerrank.com/challenges/max-array-sum
 */
public class MaxArraySum {

    static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        memo[0] = Math.max(0, arr[0]); // do not use negatives
        memo[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int sum = memo[i - 2] + arr[i]; // include non-adjacent
            int max = Math.max(sum, memo[i - 1]); // check if better not including it
            memo[i] = Math.max(memo[i], max); // pick best
        }
        return Math.max(memo[n - 1], memo[n - 2]);
    }
}

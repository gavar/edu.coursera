package edu.hackerrank.algorithms.stack;

import java.util.Stack;

/**
 * Given an integer array of size N, find the maximum of the minimum(s) of every window size in the array.
 * The window size varies from 1 to N.
 * https://www.hackerrank.com/challenges/min-max-riddle
 */
public class MinMaxRiddle {

    static long[] solve(long[] array) {
        int N = array.length;
        long[] ans = new long[N];
        long[] span = new long[N];
        Stack<Integer> stack = new Stack<>();

        // count number of ge elements to the left
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i]) stack.pop();
            span[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }

        stack.clear();

        // count number of ge elements to the right
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peek()] >= array[i]) stack.pop();
            long peek = stack.isEmpty() ? N : stack.peek();
            span[i] += peek - i - 1;
            stack.push(i);
        }

        // fill results
        for (int i = 0; i < N; i++) {
            int w = (int) span[i];
            ans[w] = Math.max(ans[w], array[i]);
        }

        // fill the gaps
        for (int i = N - 2; i >= 0; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);

        return ans;
    }
}
